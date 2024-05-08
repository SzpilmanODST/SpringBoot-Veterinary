package com.veterinary.MonolithicVeterinary.Controllers;

import com.veterinary.MonolithicVeterinary.Controllers.Dtos.DoctorDTO;
import com.veterinary.MonolithicVeterinary.Entities.Doctor;
import com.veterinary.MonolithicVeterinary.Services.Doctor.IDoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private IDoctorService doctorService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<DoctorDTO> doctorDTOList = doctorService.findAll().stream()
                .map(doctor -> DoctorDTO.builder()
                        .id(doctor.getId())
                        .name(doctor.getName())
                        .lastName(doctor.getLastName())
                        .cellphone(doctor.getCellphone())
                        .professionalId(doctor.getProfessionalId())
                        .prescriptions(doctor.getPrescriptions())
                        .build()
                ).toList();

        return ResponseEntity.ok(doctorDTOList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Doctor> optionalDoctor = doctorService.findById(id);

        if(optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();

            DoctorDTO doctorDTO = DoctorDTO.builder()
                    .id(doctor.getId())
                    .name(doctor.getName())
                    .lastName(doctor.getLastName())
                    .cellphone(doctor.getCellphone())
                    .professionalId(doctor.getProfessionalId())
                    .prescriptions(doctor.getPrescriptions())
                    .build();

            return ResponseEntity.ok(doctorDTO);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PostMapping("/save")
    public ResponseEntity<?> saveDoctor(@RequestBody @Valid DoctorDTO doctorDTO) {
        Doctor doctor = Doctor.builder()
                .name(doctorDTO.getName())
                .lastName(doctorDTO.getLastName())
                .cellphone(doctorDTO.getCellphone())
                .professionalId(doctorDTO.getProfessionalId())
                .build();

        doctorService.save(doctor);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDoctor(@RequestBody @Valid DoctorDTO doctorDTO, @PathVariable Long id) {
        Optional<Doctor> optionalDoctor = doctorService.findById(id);

        if (optionalDoctor.isPresent()) {
            Doctor doctorDb = optionalDoctor.get();

            doctorDb.setName(doctorDTO.getName());
            doctorDb.setLastName(doctorDTO.getLastName());
            doctorDb.setCellphone(doctorDTO.getCellphone());
            doctorDb.setProfessionalId(doctorDTO.getProfessionalId());

            doctorService.save(doctorDb);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Doctor> optionalDoctor = doctorService.findById(id);

        if(optionalDoctor.isPresent()) {
            doctorService.deleteById(id);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.notFound().build();
    }
}
