package com.niladri.microservice_patient.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponseDto {
  private String id;
  private String name;
  private String email;
  private String address;
  private String dateOfBirth;
}
