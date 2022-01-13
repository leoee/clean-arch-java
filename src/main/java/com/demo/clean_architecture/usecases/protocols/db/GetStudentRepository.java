package com.demo.clean_architecture.usecases.protocols.db;

import com.demo.clean_architecture.domain.Student;

public interface GetStudentRepository {
  public Student getStudent(Long id);
}
