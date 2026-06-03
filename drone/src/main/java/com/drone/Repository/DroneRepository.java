package com.drone.Repository;

import com.drone.Models.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DroneRepository extends JpaRepository<Drone,Long> {
    void deleteByCodigo(String codigo);
    Optional<Drone> findByCode(String code);
}
