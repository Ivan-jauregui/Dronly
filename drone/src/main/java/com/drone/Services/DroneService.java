package com.drone.Services;

import com.drone.Dto.DroneDto;
import com.drone.Exceptions.BusinessRuleException;
import com.drone.Exceptions.RecourseNotFound;
import com.drone.Mapper.mapper;
import com.drone.Models.Drone;
import com.drone.Repository.DroneRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class DroneService {
    private final DroneRepository repository;

    private final mapper mapper;


    public Drone save(Drone d){
        return repository.save(d);
    }

    public Drone update(Drone d){
        Drone droneDb=repository.findById(d.getId())
                .orElseThrow(()-> new RecourseNotFound("El drone no fue encontrado"));
        droneDb.setCode(d.getCode());
        droneDb.setCapacity(d.getCapacity());
        droneDb.setModel(d.getModel());
        droneDb.setState(d.getState());
        return repository.save(droneDb);
    }

    public void deleteByCodigo(String codigo){
        Drone d = repository.findByCode(codigo);
        if(!d.getState().equals("Disponible")){
            throw new BusinessRuleException("invalid operation");
        }
        repository.deleteByCodigo(codigo);
    }

    public DroneDto findById(Long id){
        Drone d=repository.findById(id)
                .orElseThrow(()-> new RecourseNotFound("El drone no fue encontrado"));
        return mapper.toDto(d);
    }

    public List<DroneDto> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

}
