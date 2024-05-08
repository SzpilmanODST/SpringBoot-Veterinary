package com.veterinary.MonolithicVeterinary.Controllers;

import com.veterinary.MonolithicVeterinary.Controllers.Dtos.PetOwnerDTO;
import com.veterinary.MonolithicVeterinary.Controllers.Dtos.PetOwnerDTOFindAll;
import com.veterinary.MonolithicVeterinary.Entities.PetOwner;
import com.veterinary.MonolithicVeterinary.Services.PetOwner.IPetOwnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/petOwner")
public class PetOwnerController {

    @Autowired
    private IPetOwnerService petOwnerService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<PetOwnerDTO> petOwnerList = petOwnerService.findAll()
                .stream()
                .map(petOwner -> PetOwnerDTO.builder()
                        .id(petOwner.getId())
                        .name(petOwner.getName())
                        .lastName(petOwner.getLastName())
                        .cellphone(petOwner.getCellphone())
                        .email(petOwner.getEmail())
                        .appointments(petOwner.getAppointments())
                        .pets(petOwner.getPets())
                        .build())
                .toList();

        return ResponseEntity.ok(petOwnerList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<PetOwner> petOwnerOptional = petOwnerService.findById(id);

        if(petOwnerOptional.isPresent()) {
            PetOwner petOwnerDb = petOwnerOptional.get();

            PetOwnerDTO petOwnerDTO = PetOwnerDTO.builder()
                    .id(petOwnerDb.getId())
                    .name(petOwnerDb.getName())
                    .lastName(petOwnerDb.getLastName())
                    .cellphone(petOwnerDb.getCellphone())
                    .email(petOwnerDb.getEmail())
                    .appointments(petOwnerDb.getAppointments())
                    .pets(petOwnerDb.getPets())
                    .build();

            return ResponseEntity.ok(petOwnerDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findByCellphone/{cellphone}")
    public ResponseEntity<?> findIdByCellphone(@PathVariable String cellphone) {
        Optional<PetOwner> petOwnerOptional = petOwnerService.findByCellphone(cellphone);

        if(petOwnerOptional.isPresent()) {
            PetOwner petOwnerDb = petOwnerOptional.get();
            PetOwnerDTO petOwnerDTO = PetOwnerDTO.builder()
                    .id(petOwnerDb.getId())
                    .name(petOwnerDb.getName())
                    .lastName(petOwnerDb.getLastName())
                    .cellphone(petOwnerDb.getCellphone())
                    .email(petOwnerDb.getEmail())
                    .appointments(petOwnerDb.getAppointments())
                    .pets(petOwnerDb.getPets())
                    .build();

            return ResponseEntity.ok(petOwnerDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveOwner(@RequestBody @Valid PetOwnerDTO petOwnerDTO) {
        petOwnerService.save(PetOwner.builder()
                .name(petOwnerDTO.getName())
                .lastName(petOwnerDTO.getLastName())
                .cellphone(petOwnerDTO.getCellphone())
                .email(petOwnerDTO.getEmail())
                .appointments(petOwnerDTO.getAppointments())
                .pets(petOwnerDTO.getPets())
                .build());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOwner(@RequestBody @Valid PetOwnerDTO petOwnerDTO, @PathVariable Long id) {
        Optional<PetOwner> petOwnerOptional = petOwnerService.findById(id);

        if(petOwnerOptional.isPresent()) {
            PetOwner petOwnerDb = petOwnerOptional.get();

            petOwnerDb.setName(petOwnerDTO.getName());
            petOwnerDb.setLastName(petOwnerDTO.getLastName());
            petOwnerDb.setCellphone(petOwnerDTO.getCellphone());
            petOwnerDb.setEmail(petOwnerDTO.getEmail());
            petOwnerDb.setAppointments(petOwnerDTO.getAppointments());
            petOwnerDb.setPets(petOwnerDTO.getPets());

            petOwnerService.save(petOwnerDb);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<PetOwner> petOwnerOptional = petOwnerService.findById(id);

        if(petOwnerOptional.isPresent()) {
            petOwnerService.deleteById(id);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.notFound().build();
    }

}
