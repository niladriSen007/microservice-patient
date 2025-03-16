package com.niladri.microservice_patient.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niladri.microservice_patient.DTOs.PatientResponseDto;
import com.niladri.microservice_patient.Services.PatientService;
import com.niladri.microservice_patient.model.Patient;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    
    /**
     * Get all patients
     * @return List of all patients
     */
    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getAllPatients() {
        return ResponseEntity.ok(patientService.findAll());
    }
    
    /**
     * Get patient by ID
     * @param id Patient ID
     * @return Patient if found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable UUID id) {
        return patientService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Create a new patient
     * @param patient Patient data
     * @return Created patient
     */
    @PostMapping
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) {
        Patient savedPatient = patientService.save(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
    }
    
    /**
     * Update an existing patient
     * @param id Patient ID
     * @param patient Updated patient data
     * @return Updated patient
     */
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable UUID id, @Valid @RequestBody Patient patient) {
        return patientService.findById(id)
            .map(existingPatient -> {
                patient.setId(id);
                return ResponseEntity.ok(patientService.save(patient));
            })
            .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Delete a patient
     * @param id Patient ID
     * @return No content if successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
        if (patientService.existsById(id)) {
            patientService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}