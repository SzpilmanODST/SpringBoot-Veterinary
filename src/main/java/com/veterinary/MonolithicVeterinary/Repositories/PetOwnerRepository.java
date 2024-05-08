package com.veterinary.MonolithicVeterinary.Repositories;

import com.veterinary.MonolithicVeterinary.Entities.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {

    Optional<PetOwner> findByCellphone(String cellphone);

}
