package com.demo.clean_architecture.domain.exceptions;

public class DuplicatedEmailException extends RuntimeException{
  public DuplicatedEmailException(String message) {
    super(message);
  }
}
