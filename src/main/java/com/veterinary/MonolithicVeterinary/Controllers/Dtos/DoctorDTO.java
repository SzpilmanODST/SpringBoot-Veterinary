package com.veterinary.MonolithicVeterinary.Controllers.Dtos;

import com.veterinary.MonolithicVeterinary.Entities.Prescription;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {

    private Long id;

    @NotBlank(message = "El campo 'Nombre' no debe estar vacío")
    private String name;

    @NotBlank(message = "El campo 'Apellido' no debe estar vacío")
    private String lastName;

    @NotBlank(message = "El campo 'Celular' no debe estar vacio")
    @Column(unique = true)
    @Size(min = 10, max = 10, message = "El campo 'Celular' debe tener 10 dígitos")
    private String cellphone;

    @NotBlank(message = "El campo 'Cedula profesional' no debe estar vacio")
    @Size(min = 6, max = 6, message = "El campo 'Cedula profesional' debe tener 6 digitos")
    @Column(unique = true)
    private String professionalId;

    private List<Prescription> prescriptions;

}
