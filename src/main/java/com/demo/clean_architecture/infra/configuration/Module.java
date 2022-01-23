package com.demo.clean_architecture.infra.configuration;

import com.demo.clean_architecture.usecases.protocols.db.AddStudentRepository;
import com.demo.clean_architecture.usecases.protocols.db.GetStudentByEmailRepository;
import com.demo.clean_architecture.usecases.protocols.db.GetStudentRepository;
import com.demo.clean_architecture.usecases.student.AddStudent;
import com.demo.clean_architecture.usecases.student.GetStudent;
import com.demo.clean_architecture.usecases.student.GetStudentByEmail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Module {
  
  @Bean
  public AddStudent createAddStudent(AddStudentRepository addStudentRepository, GetStudentByEmailRepository getStudentRepository) {
    return new AddStudent(addStudentRepository, getStudentRepository);
  }

  @Bean
  public GetStudent createGetStudent(GetStudentRepository getStudentRepository) {
    return new GetStudent(getStudentRepository);
  }

  @Bean
  public GetStudentByEmail createGetStudentByEmail(GetStudentByEmailRepository getStudentRepository) {
    return new GetStudentByEmail(getStudentRepository);
  }

}
