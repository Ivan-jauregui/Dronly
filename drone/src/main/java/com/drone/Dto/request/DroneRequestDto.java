package com.drone.Dto.request;

import com.drone.Enums.DroneState;
import com.drone.Validation.onCreate;
import com.drone.Validation.onUpdate;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class DroneRequestDto {
    @NotBlank(message = "El modelo es requerido",groups = {onCreate.class} )
    @Size(min=3,max = 20,message = "El modelo debe de tener enter 3 a 20 caracteres",groups = {onCreate.class, onUpdate.class} )
    private String model;
    @NotNull(message = "La capacidad es requerida",groups = {onCreate.class, onUpdate.class} )
    @Positive(message = "La capacidad debe ser positiva",groups = {onCreate.class, onUpdate.class} )
    @Min(value = 2,message = "Debe de poder cargar mas de 2kg",groups = {onCreate.class, onUpdate.class} )
    private Double capacity;
    @Pattern(regexp = "Disponible|EnMision|Mantenimiento",
            message = "Estado no válido",
            groups = {onCreate.class, onUpdate.class})
    private DroneState state;
}
