package com.drone.Repository;

import com.drone.Models.Misiones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MisionRepository extends JpaRepository<Misiones,Long> {
}
