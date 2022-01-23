package com.demo.clean_architecture.usecases.student;

import com.demo.clean_architecture.domain.Student;
import com.demo.clean_architecture.domain.exceptions.NotFoundException;
import com.demo.clean_architecture.usecases.protocols.db.GetStudentByEmailRepository;

public class GetStudentByEmail {
  private GetStudentByEmailRepository getStudentRepository;

  public GetStudentByEmail(GetStudentByEmailRepository getStudentRepository) {
    this.getStudentRepository = getStudentRepository;
  }

  public Student getStudentByEmail(String email) {
    try {
      Student fetchedStudent = this.getStudentRepository.getStudentByEmail(email);
      return fetchedStudent;
    } catch (Exception e) {
      throw new NotFoundException(("Could not find object with email " + email + "."));
    }
  }
}
