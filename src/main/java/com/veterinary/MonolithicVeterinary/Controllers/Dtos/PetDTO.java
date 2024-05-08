package com.veterinary.MonolithicVeterinary.Controllers.Dtos;

import com.veterinary.MonolithicVeterinary.Entities.PetOwner;
import com.veterinary.MonolithicVeterinary.Entities.Prescription;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {

    private Long id;

    @NotBlank(message = "El campo 'Nombre' no debe estar vacio")
    private String name;

    @NotBlank(message = "El campo 'Genero' no debe estar vacio")
    private String gender;

    @NotBlank(message = "El campo 'Especie' no debe estar vacio")
    private String species;

    @NotBlank(message = "El campo 'Raza' no debe estar vacio")
    private String breed;

    @NotNull(message = "El campo 'Edad' no debe estar vacio")
    private double age;

    @NotNull(message = "El campo 'Peso' no debe estar vacio")
    private double weight;

    private PetOwner petOwner;

    private List<Prescription> prescriptions;

}
