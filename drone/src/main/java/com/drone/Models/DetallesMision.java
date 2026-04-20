package com.drone.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinColumn(name = "mision_id") // <--- Nombre en la base de datos (DB)
    private Misiones mision;


}
