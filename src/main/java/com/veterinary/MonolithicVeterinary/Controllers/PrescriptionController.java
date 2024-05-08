package com.veterinary.MonolithicVeterinary.Controllers;

import com.veterinary.MonolithicVeterinary.Controllers.Dtos.PrescriptionDTO;
import com.veterinary.MonolithicVeterinary.Entities.Prescription;
import com.veterinary.MonolithicVeterinary.Services.Prescription.IPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/prescription")
public class PrescriptionController {

    @Autowired
    private IPrescriptionService prescriptionService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<PrescriptionDTO> prescriptionDTOList = prescriptionService.findAll().stream()
                .map(prescription -> PrescriptionDTO.builder()
                        .id(prescription.getId())
                        .ailment(prescription.getAilment())
                        .dayAndHour(prescription.getDayAndHour())
                        .petOwner(prescription.getPetOwner())
                        .pet(prescription.getPet())
                        .doctor(prescription.getDoctor())
                        .build()
                ).toList();

        return ResponseEntity.ok(prescriptionDTOList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Prescription> prescriptionOptional = prescriptionService.findById(id);

        if(prescriptionOptional.isPresent()) {
            Prescription prescriptionDb = prescriptionOptional.get();

            PrescriptionDTO prescriptionDTO = PrescriptionDTO.builder()
                    .id(prescriptionDb.getId())
                    .ailment(prescriptionDb.getAilment())
                    .dayAndHour(prescriptionDb.getDayAndHour())
                    .petOwner(prescriptionDb.getPetOwner())
                    .pet(prescriptionDb.getPet())
                    .doctor(prescriptionDb.getDoctor())
                    .build();

            return ResponseEntity.ok(prescriptionDTO);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    // ************************
    // @PostMapping This one is in the AppointmentController's PostMapping
    // ************************

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePrescription(@RequestBody PrescriptionDTO prescriptionDTO, @PathVariable Long id) {
        Optional<Prescription> prescriptionOptional = prescriptionService.findById(id);

        if(prescriptionOptional.isPresent()) {
            Prescription prescriptionDb = prescriptionOptional.get();

            prescriptionDb.setAilment(prescriptionDTO.getAilment());
            prescriptionDb.setPet(prescriptionDTO.getPet());
            prescriptionDb.setDoctor(prescriptionDTO.getDoctor());

            prescriptionService.save(prescriptionDb);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    // ************************
    // @DeleteMapping This one is in the relation OneToOne in Appointment Entity, in orphanRemoval = true
    // ************************
}
