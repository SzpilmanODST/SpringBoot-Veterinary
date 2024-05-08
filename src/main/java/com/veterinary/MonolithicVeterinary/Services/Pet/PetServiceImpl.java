package com.veterinary.MonolithicVeterinary.Services.Pet;

import com.veterinary.MonolithicVeterinary.Entities.Pet;
import com.veterinary.MonolithicVeterinary.Repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements IPetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public Optional<Pet> findById(Long id) {
        return petRepository.findById(id);
    }

    @Override
    public void save(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
