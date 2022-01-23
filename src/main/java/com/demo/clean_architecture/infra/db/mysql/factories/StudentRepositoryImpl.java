package com.demo.clean_architecture.infra.db.mysql.factories;

import com.demo.clean_architecture.domain.Student;
import com.demo.clean_architecture.infra.db.mysql.entities.StudentDto;
import com.demo.clean_architecture.infra.db.mysql.repositories.StudentRepository;
import com.demo.clean_architecture.usecases.protocols.db.AddStudentRepository;
import com.demo.clean_architecture.usecases.protocols.db.GetStudentByEmailRepository;
import com.demo.clean_architecture.usecases.protocols.db.GetStudentRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements AddStudentRepository, GetStudentRepository, GetStudentByEmailRepository{

  private StudentRepository studentRepository;

  public StudentRepositoryImpl(@Lazy StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public Student addStudent(Student student) {
    return StudentDto.to(studentRepository.save(StudentDto.from(student)));
  }

  @Override
  public Student getStudent(Long id) {
    return StudentDto.to(studentRepository.getById(id));
  }

  @Override
  public Student getStudentByEmail(String email) {
    return studentRepository.findByEmail(email) != null
      ? StudentDto.to(studentRepository.findByEmail(email))
      : null;
  }
  
}
