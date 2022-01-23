package com.demo.clean_architecture.presentation.rest.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

public class StudentRequest {
  @Null(message = "Id must be null")
  private Long id;

  @NotBlank(message = "Name is required")
  private String name;

  @NotBlank(message = "Course is required")
  private String course;

  @NotBlank(message = "Email is required")
  @Email(message = "Email is not a valid email")
  private String email;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCourse() {
    return this.course;
  }

  public void setCourse(String course) {
    this.course = course;
  };

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  };
}
