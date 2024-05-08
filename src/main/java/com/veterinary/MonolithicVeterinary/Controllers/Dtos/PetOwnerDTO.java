package com.veterinary.MonolithicVeterinary.Controllers.Dtos;

import com.veterinary.MonolithicVeterinary.Entities.Appointment;
import com.veterinary.MonolithicVeterinary.Entities.Pet;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetOwnerDTO {

    private Long id;

    @NotBlank(message = "El campo 'Nombre' no debe estar vacío")
    private String name;

    @NotBlank(message = "El campo 'Apellido' no debe estar vacío")
    private String lastName;

    @Column(unique = true)
    @Size(min = 10, max = 10, message = "El campo 'Celular' debe tener 10 dígitos")
    private String cellphone;

    @Email
    @Column(unique = true)
    @NotBlank(message = "El campo 'Correo electrónico' no debe estar vacío")
    private String email;

    private List<Appointment> appointments = new ArrayList<>();

    private List<Pet> pets = new ArrayList<>();

}
