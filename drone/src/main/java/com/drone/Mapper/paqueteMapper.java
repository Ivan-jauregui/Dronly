package com.drone.Mapper;

import com.drone.Dto.DroneDto;
import com.drone.Dto.PaqueteDto;
import com.drone.Models.Paquete;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface paqueteMapper {
    PaqueteDto toDto(Paquete p);
    Paquete toEntity(PaqueteDto paqueteDto);
}
