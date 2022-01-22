package com.demo.clean_architecture.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StudentTest {
  
  @Test
  public void validateNewInstance() {
    Long id = (long) 1234;
    String name = "Test_Instance";
    String course = "Engineering";
    String email = "test@mail.com";

    Student student = new Student();
    student.setId(id);
    student.setName(name);
    student.setCourse(course);
    student.setEmail(email);

    assertEquals(id, student.getId());
    assertEquals(name, student.getName());
    assertEquals(course, student.getCourse());
    assertEquals(email, student.getEmail());
  }
}
