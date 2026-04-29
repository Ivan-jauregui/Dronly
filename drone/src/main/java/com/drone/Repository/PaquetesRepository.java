package com.drone.Repository;

import com.drone.Models.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaquetesRepository extends JpaRepository<Paquete,Long> {
}
