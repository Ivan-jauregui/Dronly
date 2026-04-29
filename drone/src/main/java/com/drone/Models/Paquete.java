package com.drone.Models;

import com.drone.Validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = ValidationGroups.onUpdate.class , message = "El ID es requerido para actualizar")
    private Long id;
    @NotBlank(groups = {ValidationGroups.onCreate.class, ValidationGroups.onUpdate.class},message = "La descripcion es requerida")
    private String description;
    @Size( groups = {ValidationGroups.onCreate.class, ValidationGroups.onUpdate.class} , min = 1,max = 200, message = "El peso debe ser mayor a 1kg")
    @NotNull(groups = {ValidationGroups.onCreate.class, ValidationGroups.onUpdate.class} , message = "El peso es requerido")
    private Double weight;

}
