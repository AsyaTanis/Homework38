package com.example.logging.mappers;

import org.mapstruct.Mapper;
import com.example.logging.dto.ReportDTO;
import com.example.logging.model.ReportEntity;

@Mapper(componentModel = "spring")
public interface ReportMapper {
    ReportDTO toReportDto(ReportEntity reportEntity);
    ReportEntity toEntity(ReportDTO reportDTO);
}