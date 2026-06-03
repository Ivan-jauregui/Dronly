package com.drone.Repository;

import com.drone.Dto.MisionDto;
import com.drone.Models.Misiones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MisionRepository extends JpaRepository<Misiones,Long> {
    List<Misiones> findAllByMission_Date(LocalDateTime date);
}
