package com.demo.clean_architecture.usecases.student;

import com.demo.clean_architecture.domain.Student;
import com.demo.clean_architecture.usecases.protocols.db.AddStudentRepository;

public class AddStudent {

  private AddStudentRepository addStudentRepository;

  public AddStudent(AddStudentRepository addStudentRepository) {
    this.addStudentRepository = addStudentRepository;
  }
  
  public Student addStudent(Student student){
    return addStudentRepository.addStudent(student);
  }
}
