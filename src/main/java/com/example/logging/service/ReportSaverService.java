package com.example.logging.service;

import com.example.logging.dto.ReportDTO;

public interface ReportSaverService {
    ReportDTO saveReport(ReportDTO reportDTO);
}
