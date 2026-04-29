    package com.drone.Models;

    import com.drone.Validation.ValidationGroups;
    import jakarta.persistence.*;
    import jakarta.validation.constraints.FutureOrPresent;
    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import java.sql.Timestamp;
    import java.time.LocalDateTime;
    import java.util.List;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class Misiones {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @NotNull(groups = ValidationGroups.onUpdate.class , message = "El ID es requerido para actualizar")
        private Long id;
        @FutureOrPresent(message = "El evento debe ser en una fecha futura u hoy")
        @NotNull(message = "La fecha de mision es requerida")
        private LocalDateTime mission_date=LocalDateTime.now();

        @NotBlank(groups = {ValidationGroups.onCreate.class, ValidationGroups.onUpdate.class}, message = "El origen es requerido")
        private String origin;
        @NotBlank(groups = {ValidationGroups.onCreate.class, ValidationGroups.onUpdate.class}, message = "El destino es requerido")
        private String destination;

        private Integer starter_battery;
        private Integer final_battery;
        private Double price;

        @OneToMany(mappedBy = "mision",cascade = CascadeType.ALL)
        private List<DetallesMision> details;

        @ManyToOne
        @JoinColumn(name = "drone_id")
        private Drone drone;
    }
