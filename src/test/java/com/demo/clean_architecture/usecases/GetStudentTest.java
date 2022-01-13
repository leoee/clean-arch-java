package com.demo.clean_architecture.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.demo.clean_architecture.domain.Student;
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

    Student expectedStudent = new Student();
    expectedStudent.setId(expectedId);
    expectedStudent.setName(expectedName);

    when(getStudentRepository.getStudent(expectedId)).thenReturn(expectedStudent);

    Student fetchedStudent = this.getStudentUseCase.getStudent(expectedId);

    assertNotNull(fetchedStudent);
    assertEquals(expectedId, fetchedStudent.getId());
    assertEquals(expectedName, fetchedStudent.getName());
  }
}
