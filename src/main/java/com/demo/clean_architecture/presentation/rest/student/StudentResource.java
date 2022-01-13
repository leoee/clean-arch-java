package com.demo.clean_architecture.presentation.rest.student;


import com.demo.clean_architecture.presentation.rest.entities.StudentRequest;
import com.demo.clean_architecture.usecases.student.AddStudent;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class StudentResource {

  private AddStudent student;

  public StudentResource(AddStudent student) {
    this.student = student;
  }


  @RequestMapping(value = "/student", method = RequestMethod.POST)
  ResponseEntity<?> createStudent(@RequestBody StudentRequest studentRequest) {

    return new ResponseEntity<>(this.student.addStudent(StudentInputMapper.map(studentRequest)), HttpStatus.CREATED);
  }

}
