package com.veterinary.MonolithicVeterinary.Repositories;

import com.veterinary.MonolithicVeterinary.Entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
