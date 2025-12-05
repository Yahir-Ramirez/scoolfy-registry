package com.scoolfy.registry.persistence.repository;

import com.scoolfy.registry.persistence.entity.UserCampus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCampusRepository extends JpaRepository<UserCampus, Long> {
}