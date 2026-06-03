package com.drone.Controller;

import com.drone.Dto.Resposnse.DroneResponseDto;
import com.drone.Dto.request.DroneRequestDto;
import com.drone.Models.Drone;
import com.drone.Services.DroneService;
import com.drone.Validation.onCreate;
import com.drone.Validation.onUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drones")
@RequiredArgsConstructor
public class DroneController {
    @Autowired
    private final DroneService droneService;

    @PostMapping
    private ResponseEntity<DroneResponseDto> save(
            @Validated(onCreate.class)
            @RequestBody DroneRequestDto droneRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(droneService.save(droneRequestDto));
    }

    @PutMapping("/{code}")
    public ResponseEntity<DroneResponseDto> update(
            @Validated(onUpdate.class)
            @PathVariable String code,
            @RequestBody DroneRequestDto droneRequestDto){
        return ResponseEntity.ok(droneService.update(code,droneRequestDto));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteByCodigo(@PathVariable Long id){
        droneService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drone> findById(@PathVariable Long id){
        return ResponseEntity.ok(droneService.findById(id));

    }

    @GetMapping("/{code}")
    public ResponseEntity<DroneResponseDto> findByCode(@PathVariable String code){
        return ResponseEntity.ok(droneService.findByCode(code));
    }

    @GetMapping
    public ResponseEntity<List<DroneResponseDto>> findAll(){
        return ResponseEntity.ok(droneService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrone(Long id){
        droneService.deleteById(id);
        return  ResponseEntity.noContent().build();
    }



}
