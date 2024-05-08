package com.veterinary.MonolithicVeterinary.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
@Table(name = "doctors")
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "last_name")
    private String lastName;
    private String cellphone;

    @Column(name = "professional_id")
    private String professionalId;

    @OneToMany(mappedBy = "doctor",
            fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Prescription> prescriptions = new ArrayList<>();

}
