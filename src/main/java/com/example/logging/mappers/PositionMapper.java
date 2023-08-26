package com.example.logging.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.logging.dto.PositionDTO;
import com.example.logging.model.PositionEntity;
@Mapper(componentModel = "spring")
public interface PositionMapper {
    PositionMapper INSTANCE = Mappers.getMapper(PositionMapper.class);
    PositionDTO toPositionDTO(PositionEntity position);
}
