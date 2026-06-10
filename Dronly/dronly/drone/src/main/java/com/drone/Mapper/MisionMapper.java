package com.drone.Mapper;

import com.drone.Dto.Resposnse.MisionResponseDto;
import com.drone.Dto.request.MisionRequestDto;
import com.drone.Models.Misiones;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MisionMapper {
    @Mapping(target = "drone", source = "java(DroneRepository.findById(dto.getDroneId())")
    Misiones toEntity(MisionRequestDto misionDto);
    @Mapping(target = "droneName", source = "drone.getModel()")
    MisionResponseDto toDto(Misiones m);
}
