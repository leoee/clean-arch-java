package com.demo.clean_architecture.presentation.rest.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.demo.clean_architecture.domain.Student;
import com.demo.clean_architecture.infra.db.mysql.entities.StudentDto;
import com.demo.clean_architecture.presentation.rest.entities.StudentRequest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentResourceTest {

  @Autowired
  private TestRestTemplate testRestTemplate;

  
  @Test
  public void shouldCreateStudentWhenPassingValidBody() {
    final String name = "Testing";
    final String course = "Engineering";
    final String email = "test@mail.com";

    StudentRequest request = new StudentRequest();
    request.setName(name);
    request.setCourse(course);
    request.setEmail(email);

    HttpEntity<StudentRequest> httpEntity = new HttpEntity<>(request);

    ResponseEntity<StudentDto> response = this.testRestTemplate
        .exchange("/students", HttpMethod.POST, httpEntity, StudentDto.class);

    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(name, response.getBody().getName());
    assertEquals(course, response.getBody().getCourse());
    assertEquals(email, response.getBody().getEmail());
    assertNotNull(response.getBody().getId());

  }

  @Test
  public void shouldReturnBadrequestWhenCreatingWithoutEmail() {
    final String name = "Testing";
    final String course = "Engineering";

    StudentRequest request = new StudentRequest();
    request.setName(name);
    request.setCourse(course);

    HttpEntity<StudentRequest> httpEntity = new HttpEntity<>(request);

    ResponseEntity<StudentDto> response = this.testRestTemplate
        .exchange("/students", HttpMethod.POST, httpEntity, StudentDto.class);

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  public void shouldReturnBadrequestWhenCreatingWithoutName() {
    final String course = "Engineering";
    final String email = "test@mail.com";

    StudentRequest request = new StudentRequest();
    request.setCourse(course);
    request.setEmail(email);

    HttpEntity<StudentRequest> httpEntity = new HttpEntity<>(request);

    ResponseEntity<StudentDto> response = this.testRestTemplate
        .exchange("/students", HttpMethod.POST, httpEntity, StudentDto.class);

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  public void shouldReturnBadrequestWhenCreatingWithoutCourse() {
    final String name = "Testing";
    final String email = "test@mail.com";

    StudentRequest request = new StudentRequest();
    request.setName(name);
    request.setEmail(email);

    HttpEntity<StudentRequest> httpEntity = new HttpEntity<>(request);

    ResponseEntity<StudentDto> response = this.testRestTemplate
        .exchange("/students", HttpMethod.POST, httpEntity, StudentDto.class);

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  public void shouldReturnNotFoundWhenGettingByInvalidId() {
    final String invalidId = "1111111";
    ResponseEntity<Student> response = this.testRestTemplate
            .exchange("/students/" + invalidId, HttpMethod.GET, null, Student.class);

    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
  }
}
