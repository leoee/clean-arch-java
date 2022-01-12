package com.demo.clean_architecture.infra.db.mysql.repositories;


import com.demo.clean_architecture.infra.db.mysql.entities.StudentDto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentDto, Integer> {

}
