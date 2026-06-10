package com.drone.Controller;

import com.drone.Dto.Resposnse.MisionResponseDto;
import com.drone.Dto.request.MisionRequestDto;
import com.drone.Models.Misiones;
import com.drone.Services.MisionService;
import com.drone.Validation.onCreate;
import com.drone.Validation.onUpdate;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/mision")
@AllArgsConstructor
public class MisionController {
    @Autowired
    private final MisionService service;


    @PostMapping
    private ResponseEntity<Misiones> save(@Valid
                                         @RequestBody Misiones m){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(m));
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteByCodigo(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MisionRequestDto> findById(@PathVariable Long id){
        return service.findById(id);

    }

    @GetMapping
    public ResponseEntity<List<MisionRequestDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

}
