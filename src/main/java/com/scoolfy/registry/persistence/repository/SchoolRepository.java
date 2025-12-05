package com.scoolfy.registry.persistence.repository;

import com.scoolfy.registry.persistence.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}