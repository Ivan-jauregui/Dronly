package com.drone.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetallesMision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El destino es requerido")
    private String destino;

    @ManyToOne
    @JoinColumn(name = "mision_id")
    private Misiones mision;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paquete_id")
    private Paquete paquete;;
}
