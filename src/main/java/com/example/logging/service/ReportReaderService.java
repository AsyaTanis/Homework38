package com.example.logging.service;

import org.springframework.stereotype.Service;
import com.example.logging.dto.ReportDTO;
import com.example.logging.dto.ReportToFileJsonDTO;

@Service
public interface ReportReaderService {
    ReportToFileJsonDTO readerReport (ReportDTO reportDTO);
}