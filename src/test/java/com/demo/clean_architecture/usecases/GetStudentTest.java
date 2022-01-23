package com.demo.clean_architecture.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import javax.validation.ConstraintViolationException;

import com.demo.clean_architecture.domain.Student;
import com.demo.clean_architecture.domain.exceptions.NotFoundException;
import com.demo.clean_architecture.usecases.protocols.db.GetStudentRepository;
import com.demo.clean_architecture.usecases.student.GetStudent;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

@MockitoSettings
public class GetStudentTest {
    
  @InjectMocks
  private GetStudent getStudentUseCase;

  @Mock
  private GetStudentRepository getStudentRepository;

  @Test
  public void shouldReturnStudentWhenPassingValidId() {
    Long expectedId = (long) 1234;
    String expectedName = "expectedName";
    String expectedCourse = "expectedCourse";
    String expectedEmail= "expectedEmail@mail.com";

    Student expectedStudent = new Student();
    expectedStudent.setId(expectedId);
    expectedStudent.setName(expectedName);
    expectedStudent.setCourse(expectedCourse);
    expectedStudent.setEmail(expectedEmail);

    when(getStudentRepository.getStudent(expectedId)).thenReturn(expectedStudent);

    Student fetchedStudent = this.getStudentUseCase.getStudent(expectedId);

    assertNotNull(fetchedStudent);
    assertEquals(expectedId, fetchedStudent.getId());
    assertEquals(expectedName, fetchedStudent.getName());
    assertEquals(expectedCourse, fetchedStudent.getCourse());
    assertEquals(expectedEmail, fetchedStudent.getEmail());
  }

  @Test
  public void shouldThrowNowFoundExceptionWhenPassingInvalidId() {
    Long expectedId = (long) 1234;
    final String errorMessage = "Could not find object with id " + expectedId + ".";

    when(getStudentRepository.getStudent(expectedId)).thenThrow(ConstraintViolationException.class);

    NotFoundException exception = assertThrows(
      NotFoundException.class,
      () -> this.getStudentUseCase.getStudent(expectedId)
    );

    assertEquals(errorMessage, exception.getMessage());
  }
}
