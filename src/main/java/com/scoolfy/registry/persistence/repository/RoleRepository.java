package com.scoolfy.registry.persistence.repository;

import com.scoolfy.registry.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}