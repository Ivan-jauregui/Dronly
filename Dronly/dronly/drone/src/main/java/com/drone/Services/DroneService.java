package com.drone.Services;

import com.drone.Dto.Resposnse.DroneResponseDto;
import com.drone.Dto.request.DroneRequestDto;
import com.drone.Models.Drone;

import java.util.List;

public interface DroneService {
    //Guardar Drone
    DroneResponseDto save(DroneRequestDto droneRequestDto);

    // Actualizar Drone
    DroneResponseDto update(String code,DroneRequestDto droneRequestDto);

    // Eliminar Drone por id
    void deleteById(Long id);

	// Buscar Drone por ID
	Drone findById(Long id);

    // Listar todos los drones
    List<DroneResponseDto> findAll();

    // Buscar por codigo
    DroneResponseDto findByCode(String code);

}
