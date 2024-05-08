package com.veterinary.MonolithicVeterinary.Services.PetOwner;
import com.veterinary.MonolithicVeterinary.Entities.PetOwner;

import java.util.List;
import java.util.Optional;

public interface IPetOwnerService {

    List<PetOwner> findAll();

    Optional<PetOwner> findById(Long id);

    Optional<PetOwner> findByCellphone(String cellphone);

    void save(PetOwner petOwner);

    void deleteById(Long id);

}
