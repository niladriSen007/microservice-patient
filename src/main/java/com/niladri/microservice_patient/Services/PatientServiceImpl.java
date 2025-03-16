package com.niladri.microservice_patient.Services;

import com.niladri.microservice_patient.DTOs.PatientResponseDto;
import com.niladri.microservice_patient.Repositories.PatientRepository;
import com.niladri.microservice_patient.mapper.PatientModelMapper;
import com.niladri.microservice_patient.model.Patient;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<PatientResponseDto> findAll() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientModelMapper::mapToPatientResponseDto).toList();
    }

    @Override
    public Optional<Patient> findById(UUID id) {
        return patientRepository.findById(id);
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deleteById(UUID id) {
        patientRepository.deleteById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return patientRepository.existsById(id);
    }
}