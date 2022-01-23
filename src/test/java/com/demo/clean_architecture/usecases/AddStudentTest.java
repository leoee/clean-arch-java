package com.demo.clean_architecture.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.demo.clean_architecture.domain.Student;
import com.demo.clean_architecture.domain.exceptions.DuplicatedEmailException;
import com.demo.clean_architecture.usecases.protocols.db.AddStudentRepository;
import com.demo.clean_architecture.usecases.protocols.db.GetStudentByEmailRepository;
import com.demo.clean_architecture.usecases.student.AddStudent;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

@MockitoSettings
public class AddStudentTest {
  
  @InjectMocks
  private AddStudent addStudent;

  @Mock
  private AddStudentRepository addStudentRepository;

  @Mock
  private GetStudentByEmailRepository getStudentByEmailRepository;

  @Test
  public void shouldReturnCreatedStudentWhenPassingNewStudent() {
    Long expectedId = (long) 1234;

    final String name = "Test_Instance";
    final String course = "Engineering";
    final String email = "ab@mail.com";

    final String expectedName = "expectedName";
    final String expectedCourse = "expectedCourse";
    final String expectedEmail= "expectedEmail";

    Student student = new Student();
    student.setName(name);
    student.setCourse(course);
    student.setEmail(email);

    Student expectedStudent = new Student();
    expectedStudent.setId(expectedId);
    expectedStudent.setName(expectedName);
    expectedStudent.setCourse(expectedCourse);
    expectedStudent.setEmail(expectedEmail);

    when(getStudentByEmailRepository.getStudentByEmail(student.getEmail())).thenReturn(null);
    when(addStudentRepository.addStudent(student)).thenReturn(expectedStudent);

    Student actualStudent = this.addStudent.addStudent(student);

    assertNotNull(actualStudent.getId());
    assertEquals(expectedName, actualStudent.getName());
    assertEquals(expectedCourse, actualStudent.getCourse());
    assertEquals(expectedEmail, actualStudent.getEmail());
  }

  @Test
  public void shouldThrowDuplicatedEmailExceptionWhenPassingADuplicatedEmail() {
    final String name = "Test_Instance";
    final String course = "Engineering";
    final String email = "ab@mail.com";

    Student student = new Student();
    student.setName(name);
    student.setCourse(course);
    student.setEmail(email);

    when(getStudentByEmailRepository.getStudentByEmail(student.getEmail())).thenReturn(student);
    

    DuplicatedEmailException exception = assertThrows(
      DuplicatedEmailException.class,
      () -> this.addStudent.addStudent(student)
    );

    assertEquals("Email is already in use.", exception.getMessage());
  }
}
