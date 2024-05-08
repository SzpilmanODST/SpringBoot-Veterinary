package com.veterinary.MonolithicVeterinary.Services.Pet;

import com.veterinary.MonolithicVeterinary.Entities.Pet;

import java.util.List;
import java.util.Optional;

public interface IPetService {

    List<Pet> findAll();
    Optional<Pet> findById(Long id);

    void save(Pet pet);

    void deleteById(Long id);
}
