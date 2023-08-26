package com.example.logging.mappers;

import org.mapstruct.Mapper;
import com.example.logging.dto.EmployeeDTO;
import com.example.logging.model.EmployeeEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO toDto(EmployeeEntity employee);
    EmployeeEntity toEntity(EmployeeDTO dto);
    List<EmployeeDTO> toDto(List<EmployeeEntity> employees);
    List<EmployeeEntity> toEntity(List<EmployeeDTO> dtos);
}
