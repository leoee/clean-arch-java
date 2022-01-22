package com.demo.clean_architecture.presentation.rest.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.demo.clean_architecture.domain.Student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentResourceTest {
  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void whenGettingStudentByIdShouldReturnStudent() {
    ResponseEntity<Student> response = this.testRestTemplate
            .exchange("/students/2", HttpMethod.GET, null, Student.class);

    assertEquals(HttpStatus.CREATED, response.getStatusCode());
  }
}
