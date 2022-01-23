package com.demo.clean_architecture.infra.db.mysql.repositories;


import com.demo.clean_architecture.infra.db.mysql.entities.StudentDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<StudentDto, Long> {
  @Query(value = "SELECT * FROM STUDENT WHERE email = ?1", nativeQuery = true)
  StudentDto findByEmail(String email);
}
