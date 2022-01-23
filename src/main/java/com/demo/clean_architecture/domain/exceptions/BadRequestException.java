package com.demo.clean_architecture.domain.exceptions;

public class BadRequestException extends RuntimeException{
  public BadRequestException(String message) {
    super(message);
  }
}
