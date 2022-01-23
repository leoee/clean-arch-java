package com.demo.clean_architecture.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.demo.clean_architecture.domain.Student;
import com.demo.clean_architecture.domain.exceptions.NotFoundException;
import com.demo.clean_architecture.usecases.protocols.db.GetStudentByEmailRepository;
import com.demo.clean_architecture.usecases.student.GetStudentByEmail;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

@MockitoSettings
public class GetStudentByEmailTest {

  @InjectMocks
  private GetStudentByEmail getStudentByEmail;

  @Mock
  private GetStudentByEmailRepository getStudentByEmailRepository;

  @Test
  public void shouldReturnNewStudentWhenPassingValidEmail() {
    final Long expectedId = (long) 1234;
    final String expectedName = "expectedName";
    final String expectedCourse = "expectedCourse";
    final String expectedEmail= "expectedEmail@mail.com";

    Student student = new Student();
    student.setId(expectedId);
    student.setName(expectedName);
    student.setCourse(expectedCourse);
    student.setEmail(expectedEmail);

    when(getStudentByEmailRepository.getStudentByEmail(student.getEmail())).thenReturn(student);

    Student fetchedStudent = getStudentByEmail.getStudentByEmail(student.getEmail());

    assertNotNull(fetchedStudent.getId());
    assertEquals(expectedName, fetchedStudent.getName());
    assertEquals(expectedCourse, fetchedStudent.getCourse());
    assertEquals(expectedEmail, fetchedStudent.getEmail());
  }

  @Test
  public void shouldReturnNewStudentWhenPassingInvalidEmail() {
    final String invalidEmail = "invalidEmail";
    final String errorMessage = "Could not find object with email " + invalidEmail + ".";

    when(getStudentByEmailRepository.getStudentByEmail(invalidEmail)).thenThrow(NotFoundException.class);

    NotFoundException exception = assertThrows(
      NotFoundException.class,
      () -> getStudentByEmail.getStudentByEmail(invalidEmail)
    );

    assertEquals(errorMessage, exception.getMessage());
  }
  
}
