package com.veterinary.MonolithicVeterinary.Services.Appointment;

import com.veterinary.MonolithicVeterinary.Entities.Appointment;
import com.veterinary.MonolithicVeterinary.Repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Override
    public List<Appointment> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Appointment> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Appointment appointment) {
        repository.save(appointment);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
