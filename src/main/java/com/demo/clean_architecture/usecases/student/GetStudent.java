package com.demo.clean_architecture.usecases.student;

import com.demo.clean_architecture.domain.Student;
import com.demo.clean_architecture.usecases.protocols.db.GetStudentRepository;

public class GetStudent {
  private GetStudentRepository getStudentRepository;

  public GetStudent(GetStudentRepository getStudentRepository) {
    this.getStudentRepository = getStudentRepository;
  }

  public Student get(Long id) {
    return this.getStudentRepository.getStudent(id);
  }
}
