package com.niladri.microservice_patient.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.niladri.microservice_patient.DTOs.PagedResponseDto;
import com.niladri.microservice_patient.DTOs.PatientResponseDto;
import com.niladri.microservice_patient.Repositories.PatientRepository;
import com.niladri.microservice_patient.mapper.PatientModelMapper;
import com.niladri.microservice_patient.model.Patient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<PatientResponseDto> findAll() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientModelMapper::mapToPatientResponseDto).toList();
    }

    @Override
    public Page<PatientResponseDto> findAll(Pageable pageable) {
        return patientRepository.findAll(pageable)
                .map(PatientModelMapper::mapToPatientResponseDto);
    }

    @Override
    public PagedResponseDto<PatientResponseDto> findAllWithSortMetadata(Pageable pageable) {
        Page<PatientResponseDto> page = patientRepository.findAll(pageable)
                .map(PatientModelMapper::mapToPatientResponseDto);

        log.info(pageable.getSort().iterator().next().getProperty());

        String sortField = pageable.getSort().isEmpty() ? "" : pageable.getSort().iterator().next().getProperty();

        String sortDirection = pageable.getSort().isEmpty() ? ""
                : pageable.getSort().iterator().next().getDirection().name();

        List<PatientResponseDto> getPatientsList = page.getContent();
        int pageNo = page.getPageable().getPageNumber() + 1;
        int pageSize = page.getPageable().getPageSize();
        long totalElements = page.getTotalElements();
        int totalPages = page.getTotalPages();
        boolean isLast = page.isLast();

        return new PagedResponseDto<>(getPatientsList, pageNo, pageSize, totalElements, totalPages, isLast, sortField,
                sortDirection);
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