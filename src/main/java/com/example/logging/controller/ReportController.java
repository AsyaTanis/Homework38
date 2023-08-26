package com.example.logging.controller;

import com.example.logging.repository.ReportRepository;
import com.example.logging.service.ReportReaderService;
import com.example.logging.service.ReportService;
import org.springframework.core.io.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {
    private  final ReportService reportService;
    private final ReportReaderService reportReaderService;
    private final ReportRepository reportRepository;

    @PostMapping("/report")
    public int createReport() {
        return reportService.saveReportToJsonAndDB();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getReportById(@PathVariable int id) {
        String file = "file.json";
        String jsonFile = reportService.getReportById(id).getFilePath();
        Resource resource = new ByteArrayResource(jsonFile.getBytes());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file + "\"")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(resource);
    }
}