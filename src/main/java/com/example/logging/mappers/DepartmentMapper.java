package com.example.logging.mappers;

import org.mapstruct.Mapper;
import com.example.logging.dto.DepartmentDTO;
import com.example.logging.model.DepartmentEntity;
@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDTO toDepDto (DepartmentEntity department);
    DepartmentEntity toDepEntity (DepartmentDTO depDto);
}
