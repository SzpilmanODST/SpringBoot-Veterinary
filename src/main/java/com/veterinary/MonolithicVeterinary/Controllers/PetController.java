package com.veterinary.MonolithicVeterinary.Controllers;

import com.veterinary.MonolithicVeterinary.Controllers.Dtos.PetDTO;
import com.veterinary.MonolithicVeterinary.Entities.Pet;
import com.veterinary.MonolithicVeterinary.Services.Pet.IPetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/pet")
public class PetController {

    @Autowired
    private IPetService petService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<PetDTO> petDTOList = petService.findAll().stream()
                .map(pet -> PetDTO.builder()
                        .id(pet.getId())
                        .name(pet.getName())
                        .gender(pet.getGender())
                        .species(pet.getSpecies())
                        .breed(pet.getBreed())
                        .age(pet.getAge())
                        .weight(pet.getWeight())
                        .petOwner(pet.getPetOwner())
                        .prescriptions(pet.getPrescriptions())
                        .build())
                .toList();

        return ResponseEntity.ok(petDTOList);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Pet> optionalPet = petService.findById(id);

        if(optionalPet.isPresent()) {
            Pet pet = optionalPet.get();

            PetDTO petDTO = PetDTO.builder()
                    .id(pet.getId())
                    .name(pet.getName())
                    .gender(pet.getGender())
                    .species(pet.getSpecies())
                    .breed(pet.getBreed())
                    .age(pet.getAge())
                    .weight(pet.getWeight())
                    .petOwner(pet.getPetOwner())
                    .prescriptions(pet.getPrescriptions())
                    .build();

            return ResponseEntity.ok(petDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePet(@RequestBody @Valid PetDTO petDTO) {
        Pet pet = Pet.builder()
                .name(petDTO.getName())
                .gender(petDTO.getGender())
                .species(petDTO.getSpecies())
                .breed(petDTO.getBreed())
                .age(petDTO.getAge())
                .weight(petDTO.getWeight())
                .petOwner(petDTO.getPetOwner())
                .prescriptions(petDTO.getPrescriptions())
                .build();

        petService.save(pet);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePet(@RequestBody @Valid PetDTO petDTO, @PathVariable Long id) {
        Optional<Pet> optionalPet = petService.findById(id);

        if(optionalPet.isPresent()) {
            Pet petDb = optionalPet.get();

            petDb.setName(petDTO.getName());
            petDb.setGender(petDTO.getGender());
            petDb.setSpecies(petDTO.getSpecies());
            petDb.setBreed(petDTO.getBreed());
            petDb.setAge(petDTO.getAge());
            petDb.setWeight(petDTO.getWeight());
            petDb.setPetOwner(petDTO.getPetOwner());
            petDb.setPrescriptions(petDTO.getPrescriptions());

            petService.save(petDb);
            return ResponseEntity.ok().build();

        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Pet> optionalPet = petService.findById(id);

        if(optionalPet.isPresent()) {
            petService.deleteById(id);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.notFound().build();
    }
}
