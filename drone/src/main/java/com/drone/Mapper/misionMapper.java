package com.drone.Mapper;

import com.drone.Dto.MisionDto;
import com.drone.Dto.PaqueteDto;
import com.drone.Models.Misiones;
import com.drone.Models.Paquete;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface misionMapper {
    @Mapping(source = "drone.nombre", target = "Drone")
    @Mapping(expression = "java(misiones.getDetalles().size())", target = "detailsQuantity")
    MisionDto toDto(Misiones m);
    Misiones toEntity(MisionDto misionDto);
}
