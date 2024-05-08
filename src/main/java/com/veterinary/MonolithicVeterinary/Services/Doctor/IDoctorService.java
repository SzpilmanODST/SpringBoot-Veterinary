package com.veterinary.MonolithicVeterinary.Services.Doctor;

import com.veterinary.MonolithicVeterinary.Entities.Doctor;

import java.util.List;
import java.util.Optional;

public interface IDoctorService {

    List<Doctor> findAll();

    Optional<Doctor> findById(Long id);

    void save(Doctor doctor);

    void deleteById(Long id);

}
