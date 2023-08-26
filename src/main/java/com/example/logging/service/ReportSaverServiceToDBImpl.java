package com.example.logging.service;

import org.springframework.stereotype.Service;
import com.example.logging.dto.ReportDTO;
import com.example.logging.model.ReportEntity;
import com.example.logging.repository.ReportRepository;

@Service
public class ReportSaverServiceToDBImpl implements ReportSaverService {
    private final ReportRepository reportRepository;

    public ReportSaverServiceToDBImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public ReportDTO saveReport(ReportDTO reportDTO) {
        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setFilePath(reportDTO.getPath());
        ReportEntity report = reportRepository.save(reportEntity);
        return ReportDTO.builder()
                .path(reportDTO.getReport())
                .path(report.getFilePath())
                .build();
    }
}
