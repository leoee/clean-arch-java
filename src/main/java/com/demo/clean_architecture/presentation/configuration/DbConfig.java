package com.demo.clean_architecture.presentation.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.demo.clean_architecture.infra.db.mysql.entities"})
@EnableJpaRepositories(basePackages = {"com.demo.clean_architecture.infra.db.mysql.repositories"})
public class DbConfig {
  
}
