package com.scoolfy.registry.persistence.repository;

import com.scoolfy.registry.persistence.entity.UserRole;
import com.scoolfy.registry.persistence.entity.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
}