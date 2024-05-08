package com.veterinary.MonolithicVeterinary.Controllers.Dtos;

import com.veterinary.MonolithicVeterinary.Entities.Appointment;
import com.veterinary.MonolithicVeterinary.Entities.Doctor;
import com.veterinary.MonolithicVeterinary.Entities.Pet;
import com.veterinary.MonolithicVeterinary.Entities.PetOwner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDTO {

    private Long id;
    private String ailment;
    private Date dayAndHour;
    private PetOwner petOwner;
    private Pet pet;
    private Doctor doctor;

}
