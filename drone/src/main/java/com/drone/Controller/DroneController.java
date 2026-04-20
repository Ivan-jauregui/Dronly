package com.drone.Controller;

import com.drone.Dto.DroneDto;
import com.drone.Models.Drone;
import com.drone.Services.DroneService;
import com.drone.Validation.ValidationGroups.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/drones")
public class DroneController {
    @Autowired
    private final DroneService service;

    @PostMapping
    private ResponseEntity<Drone> save(@Validated(onCreate.class)
                                            @Valid
                                            @RequestBody Drone d){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(d));
    }

    @PutMapping
    public Drone update(@Validated(onUpdate.class)
                             @Valid
                             @RequestBody Drone d){
        return service.save(d);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteByCodigo(@PathVariable String codigo){
        service.deleteByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DroneDto> findById(@PathVariable Long id){
        DroneDto drone = service.findById(id);
        return (drone != null) ? ResponseEntity.ok(drone) : ResponseEntity.notFound().build();

    }

    @GetMapping
    public ResponseEntity<List<DroneDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

}
