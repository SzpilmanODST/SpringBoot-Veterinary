package com.veterinary.MonolithicVeterinary.Services.Appointment;

import com.veterinary.MonolithicVeterinary.Entities.Appointment;

import java.util.List;
import java.util.Optional;

public interface IAppointmentService {

    List<Appointment> findAll();
    Optional<Appointment> findById(Long id);
    void save(Appointment appointment);
    void deleteById(Long id);

}
