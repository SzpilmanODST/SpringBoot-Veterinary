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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pets")
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private String species;
    private String breed;
    private double age;
    private double weight;

    @ManyToOne
    @JoinColumn(name = "id_petowner")
    @JsonIgnore
    private PetOwner petOwner;

    @OneToMany(mappedBy = "pet",
            fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Prescription> prescriptions = new ArrayList<>();

}
