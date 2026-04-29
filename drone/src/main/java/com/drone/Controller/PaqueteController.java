package com.drone.Controller;

import com.drone.Dto.DroneDto;
import com.drone.Dto.PaqueteDto;
import com.drone.Models.Drone;
import com.drone.Models.Paquete;
import com.drone.Services.DroneService;
import com.drone.Services.PaqueteService;
import com.drone.Validation.ValidationGroups;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paquetes")
@AllArgsConstructor
public class PaqueteController {

    @Autowired
    private final PaqueteService service;


    @PostMapping
    private ResponseEntity<Paquete> save(@Validated(ValidationGroups.onCreate.class)
                                       @Valid
                                       @RequestBody Paquete p){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(p));
    }

    @PutMapping
    public Paquete update(@Validated(ValidationGroups.onUpdate.class)
                        @Valid
                        @RequestBody Paquete p){
        return service.save(p);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteByCodigo(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaqueteDto> findById(@PathVariable Long id){
        PaqueteDto paquete = service.findById(id);
        return (paquete != null) ? ResponseEntity.ok(paquete) : ResponseEntity.notFound().build();

    }

    @GetMapping
    public ResponseEntity<List<PaqueteDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

}
