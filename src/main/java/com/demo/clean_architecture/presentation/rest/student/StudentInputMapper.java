package com.demo.clean_architecture.presentation.rest.student;

import com.demo.clean_architecture.domain.Student;
import com.demo.clean_architecture.presentation.rest.entities.StudentRequest;

public final class StudentInputMapper {
  

  public static Student map(StudentRequest request) {
    Student student = new Student();
    student.setId(request.getId());
    student.setName(request.getName());
    student.setCourse(request.getCourse());
    student.setEmail(request.getEmail());

    return student;
  }
}
