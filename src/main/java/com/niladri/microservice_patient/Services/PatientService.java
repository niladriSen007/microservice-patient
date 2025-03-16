package com.niladri.microservice_patient.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.niladri.microservice_patient.DTOs.PatientResponseDto;
import com.niladri.microservice_patient.model.Patient;

/**
 * Service interface for Patient operations
 */
public interface PatientService {
    /**
     * Find all patients
     * @return List of all patients
     */
    List<PatientResponseDto> findAll();
    
    /**
     * Find patient by ID
     * @param id Patient ID
     * @return Optional containing patient if found
     */
    Optional<Patient> findById(UUID id);
    
    /**
     * Save a patient (create or update)
     * @param patient Patient to save
     * @return Saved patient
     */
    Patient save(Patient patient);
    
    /**
     * Delete a patient by ID
     * @param id Patient ID
     */
    void deleteById(UUID id);
    
    /**
     * Check if patient exists by ID
     * @param id Patient ID
     * @return true if patient exists
     */
    boolean existsById(UUID id);
}