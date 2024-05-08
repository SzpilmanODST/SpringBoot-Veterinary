package com.veterinary.MonolithicVeterinary.Controllers;

import com.veterinary.MonolithicVeterinary.Controllers.Dtos.AppointmentDTO;
import com.veterinary.MonolithicVeterinary.Entities.Appointment;
import com.veterinary.MonolithicVeterinary.Entities.Prescription;
import com.veterinary.MonolithicVeterinary.Services.Appointment.IAppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<AppointmentDTO> appointmentDTOList = appointmentService.findAll().stream()
                .map(appointment -> AppointmentDTO.builder()
                        .id(appointment.getId())
                        .dayAndHour(appointment.getDayAndHour())
                        .petOwner(appointment.getPetOwner())
                        .prescription(appointment.getPrescription())
                        .build())
                .toList();

        return ResponseEntity.ok(appointmentDTOList);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Appointment> appointmentOptional = appointmentService.findById(id);

        if(appointmentOptional.isPresent()) {
            Appointment appointmentDb = appointmentOptional.get();

            AppointmentDTO appointmentDTO = AppointmentDTO.builder()
                    .id(appointmentDb.getId())
                    .dayAndHour(appointmentDb.getDayAndHour())
                    .petOwner(appointmentDb.getPetOwner())
                    .build();

            return ResponseEntity.ok(appointmentDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveAppointment(@RequestBody @Valid AppointmentDTO appointmentDTO) {

        // Here is the Prescription POST
        Prescription prescription = new Prescription();
        prescription.setPetOwner(appointmentDTO.getPetOwner());
        prescription.setDayAndHour(appointmentDTO.getDayAndHour());
        

        Appointment appointment = Appointment.builder()
                .dayAndHour(appointmentDTO.getDayAndHour())
                .petOwner(appointmentDTO.getPetOwner())
                .prescription(prescription)
                .build();

        appointmentService.save(appointment);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAppointment(@RequestBody @Valid AppointmentDTO appointmentDTO, @PathVariable Long id) {
        Optional<Appointment> appointmentOptional = appointmentService.findById(id);

        if(appointmentOptional.isPresent()) {
            Appointment appointmentDb = appointmentOptional.get();

            appointmentDb.setDayAndHour(appointmentDTO.getDayAndHour());
            appointmentDb.setPetOwner(appointmentDTO.getPetOwner());

            appointmentService.save(appointmentDb);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Appointment> appointmentOptional = appointmentService.findById(id);

        if(appointmentOptional.isPresent()) {
            appointmentService.deleteById(id);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.notFound().build();
    }

}
