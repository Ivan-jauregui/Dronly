package com.drone.Services.impl;

import com.drone.Dto.Resposnse.DroneResponseDto;
import com.drone.Dto.request.DroneRequestDto;
import com.drone.Exceptions.RecourseNotFound;
import com.drone.Mapper.DroneMapper;
import com.drone.Models.Drone;
import com.drone.Repository.DroneRepository;
import com.drone.Services.DroneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DroneServiceImpl implements DroneService {
    private final DroneRepository droneRepository;
    private final DroneMapper droneMapper;


    @Override
    public DroneResponseDto save(DroneRequestDto droneRequestDto) {
        return droneMapper.toDto(droneRepository.save(droneMapper.toEntity(droneRequestDto)));
    }

    @Override
    public DroneResponseDto update(String code, DroneRequestDto droneRequestDto) {
        Drone existingDrone = this.findEntityByCode(code);

        droneMapper.updateDroneFromDto(droneRequestDto,existingDrone);

        return droneMapper.toDto(droneRepository.save(existingDrone));
     }

    @Override
    public void deleteById(Long id) {
        droneRepository.deleteById(id);
    }

    @Override
    public Drone findById(Long id) {
        return droneRepository.findById(id)
                .orElseThrow(()-> new RecourseNotFound("El Drone no fue encontrado"));
    }

    @Override
    public List<DroneResponseDto> findAll() {
        return droneRepository.findAll()
                .stream()
                .map(droneMapper::toDto)
                .toList();
    }

    @Override
    public DroneResponseDto findByCode(String code) {
        Drone drone  = this.findEntityByCode(code);

        return  droneMapper.toDto(drone);
    }


    public Drone findEntityByCode(String code){
        return droneRepository.findByCode(code)
                .orElseThrow(()-> new RecourseNotFound("El Drone no fue encontrado"));
    }
}
