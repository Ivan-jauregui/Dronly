package com.drone.Services;

import com.drone.Dto.MisionDto;
import com.drone.Dto.PaqueteDto;
import com.drone.Exceptions.RecourseNotFound;
import com.drone.Mapper.misionMapper;
import com.drone.Mapper.paqueteMapper;
import com.drone.Models.Misiones;
import com.drone.Models.Paquete;
import com.drone.Repository.MisionRepository;
import com.drone.Repository.PaquetesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MisionService {
    private final MisionRepository repository;

    private final misionMapper mapper;


    public Misiones save(Misiones m){
        return repository.save(m);
    }

    public Misiones update(Misiones m){
        Misiones misionDb=repository.findById(m.getId())
                .orElseThrow(()-> new RecourseNotFound("El mision no fue encontrado"));
        misionDb.setDetails(m.getDetails());
        misionDb.setPrice(m.getPrice());
        misionDb.setStarter_battery(m.getStarter_battery());
        misionDb.setFinal_battery(m.getFinal_battery());
        misionDb.setDrone(m.getDrone());
        return repository.save(misionDb);
    }

    public void deleteById(Long id){
        Optional<Misiones> m = Optional.of(repository.findById(id)
                .orElseThrow(() -> new RecourseNotFound("La mision no fue encontrado")));

        repository.deleteById(id);
    }

    public MisionDto findById(Long id){
        Misiones m=repository.findById(id)
                .orElseThrow(()-> new RecourseNotFound("El mision no fue encontrado"));
        return mapper.toDto(m);
    }

    public List<MisionDto> findByDate(LocalDateTime date){
        List<Misiones> misiones=repository.findAllByMission_Date(date);

        return misiones.stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<MisionDto> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
