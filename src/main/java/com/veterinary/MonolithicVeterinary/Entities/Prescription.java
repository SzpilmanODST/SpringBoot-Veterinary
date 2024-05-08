package com.veterinary.MonolithicVeterinary.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prescriptions")
@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ailment;

    @Column(name = "day_and_hour")
    private Date dayAndHour;

    @ManyToOne
    @JoinColumn(name = "id_petowner")
    @JsonIgnore
    private PetOwner petOwner;

    @ManyToOne
    @JoinColumn(name = "id_pet")
    @JsonIgnore
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    @JsonIgnore
    private Doctor doctor;

}
