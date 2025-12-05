package com.scoolfy.registry.persistence.repository;

import com.scoolfy.registry.persistence.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
    Optional<Grade> findByGradeUnitAndGroupUnit(String gradeUnit, String groupUnit);
}