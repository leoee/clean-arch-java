package com.demo.clean_architecture.usecases.protocols.db;

import com.demo.clean_architecture.domain.Student;

public interface AddStudentRepository {
  public Student add(Student student);
}
