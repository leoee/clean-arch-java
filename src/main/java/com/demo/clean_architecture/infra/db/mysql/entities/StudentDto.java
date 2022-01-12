package com.demo.clean_architecture.infra.db.mysql.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.demo.clean_architecture.domain.Student;

@Entity
public class StudentDto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static StudentDto from(Student student) {
    StudentDto studentDto = new StudentDto();
    studentDto.setId(student.getId());
    studentDto.setName(student.getName());

    return studentDto;
  }

  public static Student to(StudentDto studentDto) {
    Student student = new Student();
    student.setId(studentDto.getId());
    student.setName(studentDto.getName());

    return student;
  }

}
