package com.drone.Models;

import com.drone.Validation.ValidationGroups.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = onUpdate.class , message = "El ID es requerido para actualizar")
    private Long id;
    @NotBlank(groups = {onCreate.class, onUpdate.class}, message = "El codigo es requerido")
    @Column(unique = true)
    private String code;
    @Min(value = 1, message = "La capacidad mínima es 1kg", groups = {onCreate.class, onUpdate.class})
    private Double capacity ;
    @NotBlank(groups = {onCreate.class, onUpdate.class} , message = "El modelo es requerido")
    private String model;

    @Pattern(regexp = "Disponible|EnMision|Mantenimiento",
            message = "Estado no válido",
            groups = {onCreate.class, onUpdate.class})
    private String state;

    @OneToMany(mappedBy = "drone",cascade = CascadeType.ALL)
    private List<Misiones> misiones;
}
