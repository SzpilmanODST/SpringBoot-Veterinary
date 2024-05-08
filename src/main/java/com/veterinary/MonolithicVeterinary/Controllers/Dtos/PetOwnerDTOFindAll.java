package com.veterinary.MonolithicVeterinary.Controllers.Dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetOwnerDTOFindAll {

    private Long id;
    private String name;
    private String lastName;
    private String cellphone;
    private String email;

}
