package com.drone.Mapper;

import com.drone.Dto.Resposnse.DroneResponseDto;
import com.drone.Dto.request.DroneRequestDto;
import com.drone.Models.Drone;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DroneMapper {
    DroneResponseDto toDto(Drone drone);
    Drone toEntity(DroneRequestDto droneDto);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "model",ignore = true )
    void updateDroneFromDto(DroneRequestDto droneRequestDto,Drone drone);
}
