package com.drone.Services;

import com.drone.Dto.DroneDto;
import com.drone.Dto.PaqueteDto;
import com.drone.Exceptions.BusinessRuleException;
import com.drone.Exceptions.RecourseNotFound;
import com.drone.Mapper.mapper;
import com.drone.Mapper.paqueteMapper;
import com.drone.Models.Drone;
import com.drone.Models.Paquete;
import com.drone.Repository.DroneRepository;
import com.drone.Repository.PaquetesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaqueteService {
    private final PaquetesRepository repository;

    private final paqueteMapper mapper;


    public Paquete save(Paquete p){
        return repository.save(p);
    }

    public Paquete update(Paquete p){
        Paquete paqueteDb=repository.findById(p.getId())
                .orElseThrow(()-> new RecourseNotFound("El paquete no fue encontrado"));
        paqueteDb.setDescription(p.getDescription());
        paqueteDb.setWeight(p.getWeight());
        return repository.save(paqueteDb);
    }

    public void deleteById(Long id){
        Optional<Paquete> p = Optional.of(repository.findById(id)
                .orElseThrow(() -> new RecourseNotFound("El paquete no fue encontrado")));

        repository.deleteById(id);
    }

    public PaqueteDto findById(Long id){
        Paquete p=repository.findById(id)
                .orElseThrow(()-> new RecourseNotFound("El paquete no fue encontrado"));
        return mapper.toDto(p);
    }

    public List<PaqueteDto> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
