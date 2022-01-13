package com.demo.clean_architecture.presentation.rest.student;


import com.demo.clean_architecture.presentation.rest.entities.StudentRequest;
import com.demo.clean_architecture.usecases.student.AddStudent;
import com.demo.clean_architecture.usecases.student.GetStudent;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class StudentResource {

  private AddStudent addStudentUseCase;
  private GetStudent getStudentUseCase;

  public StudentResource(AddStudent addStudent, GetStudent getStudent) {
    this.addStudentUseCase = addStudent;
    this.getStudentUseCase = getStudent;
  }


  @RequestMapping(value = "/student", method = RequestMethod.POST)
  ResponseEntity<?> createStudent(@RequestBody StudentRequest studentRequest) {

    return new ResponseEntity<>(this.addStudentUseCase.addStudent(StudentInputMapper.map(studentRequest)), HttpStatus.CREATED);
  }

  @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
  ResponseEntity<?> getStudent(@PathVariable Long id) {

    return new ResponseEntity<>(this.getStudentUseCase.getStudent(id), HttpStatus.CREATED);
  }

}
