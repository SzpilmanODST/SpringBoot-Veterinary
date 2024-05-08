package com.veterinary.MonolithicVeterinary.Controllers.Dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.veterinary.MonolithicVeterinary.Entities.PetOwner;
import com.veterinary.MonolithicVeterinary.Entities.Prescription;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {

    private Long id;

    @NotNull(message = "El campo 'Día y hora' no debe estar vacío")
    @Column(unique = true)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH")
    private Date dayAndHour;

    @NotNull(message = "El campo 'Dueño de mascota' no debe estar vacío")
    private PetOwner petOwner;
    private Prescription prescription;


}
