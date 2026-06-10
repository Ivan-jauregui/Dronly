package com.drone.Dto.request;

import com.drone.Models.Drone;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MisionRequestDto {
    @NotBlank(message = "El origen es requerido")
    private String origin;
    @NotBlank(message = "El origen es requerido")
    private String destination;
    private Long drone;
}
