package com.veterinary.MonolithicVeterinary.Services.Prescription;

import com.veterinary.MonolithicVeterinary.Entities.Prescription;

import java.util.List;
import java.util.Optional;

public interface IPrescriptionService {

    List<Prescription> findAll();

    Optional<Prescription> findById(Long id);

    void save(Prescription prescription);

    void delete(Long id);

}
