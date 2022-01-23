package com.demo.clean_architecture.usecases.student;

import com.demo.clean_architecture.domain.Student;
import com.demo.clean_architecture.domain.exceptions.DuplicatedEmailException;
import com.demo.clean_architecture.usecases.protocols.db.AddStudentRepository;
import com.demo.clean_architecture.usecases.protocols.db.GetStudentByEmailRepository;

public class AddStudent {

  private AddStudentRepository addStudentRepository;
  private GetStudentByEmailRepository getStudentByEmailRepository;

  public AddStudent(AddStudentRepository addStudentRepository, GetStudentByEmailRepository getStudentByEmailRepository) {
    this.addStudentRepository = addStudentRepository;
    this.getStudentByEmailRepository = getStudentByEmailRepository;
  }

  public Student addStudent(Student student) {
    if (getStudentByEmailRepository.getStudentByEmail(student.getEmail()) != null) {
      throw new DuplicatedEmailException("Email is already in use.");
    }

    return addStudentRepository.addStudent(student);
  }
}
