package com.demo.clean_architecture.infra.db.mysql.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.demo.clean_architecture.domain.Student;

@Entity
@Table(name = "student")
public class StudentDto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String course;
  private String email;

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

  public String getCourse() {
    return this.course;
  }

  public void setCourse(String course) {
    this.course = course;
  };

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  };

  public static StudentDto from(Student student) {
    StudentDto studentDto = new StudentDto();
    studentDto.setId(student.getId());
    studentDto.setName(student.getName());
    studentDto.setCourse(student.getCourse());
    studentDto.setEmail(student.getEmail());

    return studentDto;
  }

  public static Student to(StudentDto studentDto) {
    Student student = new Student();
    student.setId(studentDto.getId());
    student.setName(studentDto.getName());
    student.setCourse(studentDto.getCourse());
    student.setEmail(studentDto.getEmail());

    return student;
  }

}
