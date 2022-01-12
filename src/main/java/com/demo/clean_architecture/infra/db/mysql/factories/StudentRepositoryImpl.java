package com.demo.clean_architecture.infra.db.mysql.factories;

import com.demo.clean_architecture.domain.Student;
import com.demo.clean_architecture.infra.db.mysql.entities.StudentDto;
import com.demo.clean_architecture.infra.db.mysql.repositories.StudentRepository;
import com.demo.clean_architecture.usecases.protocols.db.AddStudentRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements AddStudentRepository{

  private StudentRepository studentRepository;

  public StudentRepositoryImpl(@Lazy StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public Student add(Student student) {
    System.out.println("chegou");
    StudentDto studentDto = studentRepository.save(StudentDto.from(student));
    return StudentDto.to(studentDto);
  }
  
}
