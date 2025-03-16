package com.niladri.microservice_patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.niladri.microservice_patient.exception.ErrorResponse.ApiErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorResponse<Object>> handleResourceNotFoundException(
      ResourceNotFoundException e) {
    ApiErrorResponse apiError = ApiErrorResponse.builder().status(HttpStatus.BAD_REQUEST).message(e.getMessage())
        .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse<>(apiError));
  }
  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<ErrorResponse<Object>> handleValidationException(
    ValidationException e) {
    ApiErrorResponse apiError = ApiErrorResponse.builder().status(HttpStatus.BAD_REQUEST).message(e.getMessage())
        .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse<>(apiError));
  }

}