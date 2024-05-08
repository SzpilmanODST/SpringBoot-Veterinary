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
@Table(name = "appointments")
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day_and_hour")
    private Date dayAndHour;

    @ManyToOne
    @JoinColumn(name = "id_petowner")
    @JsonIgnore
    private PetOwner petOwner;

    @OneToOne(cascade = CascadeType.PERSIST,
                orphanRemoval = true)
    @JsonIgnore
    private Prescription prescription;


}
