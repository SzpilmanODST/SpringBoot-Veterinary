package com.veterinary.MonolithicVeterinary.Services.PetOwner;

import com.veterinary.MonolithicVeterinary.Entities.Appointment;
import com.veterinary.MonolithicVeterinary.Entities.PetOwner;
import com.veterinary.MonolithicVeterinary.Repositories.PetOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetOwnerServiceImpl implements IPetOwnerService {

    @Autowired
    private PetOwnerRepository repository;

    @Override
    public List<PetOwner> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PetOwner> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<PetOwner> findByCellphone(String cellphone) {
        return repository.findByCellphone(cellphone);
    }

    @Override
    public void save(PetOwner petOwner) {
        repository.save(petOwner);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
