package com.demo.clean_architecture.presentation.rest.common;

import com.demo.clean_architecture.domain.exceptions.NotFoundException;
import com.demo.clean_architecture.presentation.rest.entities.GlobalApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = { NotFoundException.class })
  ResponseEntity<?> handleDomainException(NotFoundException ex) {
      return new ResponseEntity<>(new GlobalApiResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
  }
}