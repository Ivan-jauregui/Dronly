package com.drone.Mapper;

import com.drone.Dto.DroneDto;
import com.drone.Models.Drone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface mapper {
    DroneDto toDto(Drone drone);
    DroneDto toEntity(DroneDto droneDto);
}
