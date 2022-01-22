package com.demo.clean_architecture.presentation.rest.entities;

public class GlobalApiResponse {
  private String message;

  public GlobalApiResponse(String message) {
    this.message = message;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  };

}
