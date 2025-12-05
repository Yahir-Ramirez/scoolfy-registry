package com.scoolfy.registry.persistence.repository;

import com.scoolfy.registry.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}