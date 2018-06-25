package com.project.tres.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.tres.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
