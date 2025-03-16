package com.niladri.microservice_patient.exception;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse<T> {
  private LocalDateTime timestamp;
  private T data;
  private ApiErrorResponse errors;

  @Data
  @Builder
  public static class ApiErrorResponse {
    private HttpStatus status;
    private String message;
    private Map<String, String> subErrors;
  }

  public ErrorResponse() {
    this.timestamp = LocalDateTime.now();
  }

  public ErrorResponse(T data) {
    this();
    this.data = data;
  }

  public ErrorResponse(ApiErrorResponse error) {
    this();
    this.errors = error;
  }

}