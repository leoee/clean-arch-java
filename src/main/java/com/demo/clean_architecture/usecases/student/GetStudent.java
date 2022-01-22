package com.demo.clean_architecture.usecases.student;

import com.demo.clean_architecture.domain.Student;
import com.demo.clean_architecture.domain.exceptions.NotFoundException;
import com.demo.clean_architecture.usecases.protocols.db.GetStudentRepository;

public class GetStudent {
  private GetStudentRepository getStudentRepository;

  public GetStudent(GetStudentRepository getStudentRepository) {
    this.getStudentRepository = getStudentRepository;
  }

  public Student getStudent(Long id) {
    try {
      Student fetchedStudent = this.getStudentRepository.getStudent(id);
      return fetchedStudent;
    } catch (Exception e) {
      throw new NotFoundException(("Could not find object with id " + id));
    }
  }
}
