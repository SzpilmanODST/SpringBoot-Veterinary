package com.veterinary.MonolithicVeterinary.Repositories;

import com.veterinary.MonolithicVeterinary.Entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

}
