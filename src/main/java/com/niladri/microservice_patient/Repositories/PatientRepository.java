package com.niladri.microservice_patient.Repositories;

import com.niladri.microservice_patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for Patient entity
 * Provides CRUD operations for Patient objects
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    // Spring Data JPA will automatically implement basic CRUD operations
    // Custom query methods can be added here if needed
}