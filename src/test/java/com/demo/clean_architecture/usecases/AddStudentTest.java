package com.demo.clean_architecture.usecases;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.demo.clean_architecture.domain.Student;
import com.demo.clean_architecture.usecases.protocols.db.AddStudentRepository;
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

  @Test
  public void shouldReturnCreatedStudentWhenPassingStudent() {
    Long expectedId = (long) 1234;
    String name = "Test_Instance";
    String course = "Engineering";
    String expectedName = "expectedName";
    String expectedCourse = "expectedCourse";

    Student student = new Student();
    student.setName(name);
    student.setCourse(course);

    Student expectedStudent = new Student();
    expectedStudent.setId(expectedId);
    expectedStudent.setName(expectedName);
    expectedStudent.setCourse(expectedCourse);

    when(addStudentRepository.addStudent(student)).thenReturn(expectedStudent);

    Student actualStudent = this.addStudent.addStudent(student);

    assertNotNull(actualStudent.getId());
  }
}
