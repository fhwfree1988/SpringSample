package me.samplespring.my_samples.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.validation.constraints.NotNull;

import lombok.*;

import me.samplespring.my_samples.domain.User;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private Long id;

    @NotNull
    private LocalDate reservationDate;

    @NotNull
    @Schema(type = "string", example = "14:30")
    private LocalTime startTime;

    @NotNull
    @Schema(type = "string", example = "14:30")
    private LocalTime endTime;

    @NotNull
    private User user;

    @NotNull
    private Types.AmenityType amenityType;


}
