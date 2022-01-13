package com.demo.clean_architecture.presentation.configuration;

import com.demo.clean_architecture.usecases.protocols.db.AddStudentRepository;
import com.demo.clean_architecture.usecases.protocols.db.GetStudentRepository;
import com.demo.clean_architecture.usecases.student.AddStudent;
import com.demo.clean_architecture.usecases.student.GetStudent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Module {
  
  @Bean
  public AddStudent createAddStudent(AddStudentRepository addStudentRepository) {
    return new AddStudent(addStudentRepository);
  }

  @Bean
  public GetStudent createGetStudent(GetStudentRepository getStudentRepository) {
    return new GetStudent(getStudentRepository);
  }

}
