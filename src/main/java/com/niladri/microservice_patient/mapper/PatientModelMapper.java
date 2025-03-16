package com.niladri.microservice_patient.mapper;

import java.time.LocalDate;

import com.niladri.microservice_patient.DTOs.PatientRequestDto;
import com.niladri.microservice_patient.DTOs.PatientResponseDto;
import com.niladri.microservice_patient.model.Patient;

public class PatientModelMapper {

  private PatientModelMapper() {
  }
  public static PatientResponseDto mapToPatientResponseDto(Patient patient) {
    PatientResponseDto patientResponseDto = new PatientResponseDto();
    patientResponseDto.setId(patient.getId().toString());
    patientResponseDto.setName(patient.getName());
    patientResponseDto.setEmail(patient.getEmail());
    patientResponseDto.setAddress(patient.getAddress());
    patientResponseDto.setDateOfBirth(patient.getDateOfBirth().toString());
    return patientResponseDto;
  }

 /*  public static Patient mapToPatient(PatientRequestDto patientResponseDto) {
    Patient patient = new Patient();
    patient.setName(patientResponseDto.getName());
    patient.setEmail(patientResponseDto.getEmail());
    patient.setAddress(patientResponseDto.getAddress());
    patient.setDateOfBirth(LocalDate.parse(patientResponseDto.getDateOfBirth()));
    patient.setRegisteredDate(LocalDate.parse(patientResponseDto.get()));
    return patient;
  } */
  
}
