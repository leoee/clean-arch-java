package com.demo.clean_architecture.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.demo.clean_architecture.presentation", "com.demo.clean_architecture.infra.db.mysql"}, exclude={SecurityAutoConfiguration.class})
public class CleanArchitectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(CleanArchitectureApplication.class, args);
    }
}
