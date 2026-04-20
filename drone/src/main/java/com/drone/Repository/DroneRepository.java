package com.drone.Repository;

import com.drone.Models.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone,Long> {
    void deleteByCodigo(String codigo);
    Drone findByCode(String code);
}
