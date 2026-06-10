package com.drone.Dto.Resposnse;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class DroneResponseDto {
    private String model;
    private String code;
}
