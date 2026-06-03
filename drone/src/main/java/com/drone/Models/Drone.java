package com.drone.Models;

import com.drone.Enums.DroneState;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code;
    @Column(nullable = false)
    private Double capacity ;
    @Column(nullable = false)
    private String model;

    @Enumerated(EnumType.STRING)
    private DroneState state;

    @OneToMany(mappedBy = "drone",cascade = CascadeType.ALL)
    private List<Misiones> misiones;

    @PrePersist
    protected void onCreate(){
        if(state==null){
            state = DroneState.DISPONIBLE;
        }
        if(code==null){
            code= UUID.randomUUID().toString().substring(0, 5);
        }

    }
}
