package com.veterinary.MonolithicVeterinary.Services.Prescription;

import com.veterinary.MonolithicVeterinary.Entities.Prescription;
import com.veterinary.MonolithicVeterinary.Repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements IPrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public List<Prescription> findAll() {
        return prescriptionRepository.findAll();
    }

    @Override
    public Optional<Prescription> findById(Long id) {
        return prescriptionRepository.findById(id);
    }

    @Override
    public void save(Prescription prescription) {
        prescriptionRepository.save(prescription);
    }

    @Override
    public void delete(Long id) {
        prescriptionRepository.deleteById(id);
    }
}
