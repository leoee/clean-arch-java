package com.demo.clean_architecture.presentation.configuration;

import com.demo.clean_architecture.usecases.protocols.db.AddStudentRepository;
import com.demo.clean_architecture.usecases.student.AddStudent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Module {
  
  @Bean
  public AddStudent createAddStudent(AddStudentRepository addStudentRepository) {
    return new AddStudent(addStudentRepository);
  }

}
