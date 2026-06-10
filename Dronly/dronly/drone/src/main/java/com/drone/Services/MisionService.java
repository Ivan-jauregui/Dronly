package com.drone.Services;

import com.drone.Dto.Resposnse.MisionResponseDto;
import com.drone.Dto.request.MisionRequestDto;
import com.drone.Exceptions.RecourseNotFound;
import com.drone.Mapper.MisionMapper;
import com.drone.Models.Misiones;
import com.drone.Repository.MisionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MisionService {
    private final MisionRepository repository;

    private final MisionMapper mapper;


    public MisionResponseDto save(MisionRequestDto m){
        return repository.save(m);
    }


    public void deleteById(Long id){
        Optional<Misiones> m = Optional.of(repository.findById(id)
                .orElseThrow(() -> new RecourseNotFound("La mision no fue encontrado")));

        repository.deleteById(id);
    }

    public MisionResponseDto findById(Long id){
        Misiones m=repository.findById(id)
                .orElseThrow(()-> new RecourseNotFound("El mision no fue encontrado"));
        return mapper.toDto(m);
    }

    public List<MisionResponseDto> findByDate(LocalDateTime date){
        List<Misiones> misiones=repository.findAllByMission_Date(date);

        return misiones.stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<MisionResponseDto> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
