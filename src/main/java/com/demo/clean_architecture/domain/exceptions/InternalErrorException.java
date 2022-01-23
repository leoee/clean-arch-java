package com.demo.clean_architecture.domain.exceptions;

public class InternalErrorException extends RuntimeException{
  public InternalErrorException(String message) {
    super(message);
  }
}
