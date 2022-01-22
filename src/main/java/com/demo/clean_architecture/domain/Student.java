package com.demo.clean_architecture.domain;
public class Student {
  private Long id;
  private String name;
  private String course;
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
