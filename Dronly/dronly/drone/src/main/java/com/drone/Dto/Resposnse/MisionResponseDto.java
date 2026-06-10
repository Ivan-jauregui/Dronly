package com.drone.Dto.Resposnse;

import com.drone.Models.Drone;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MisionResponseDto {
    private String origin;
    private String destination;
    private double price;
    private String droneName;
}
