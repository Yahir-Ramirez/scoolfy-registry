package com.scoolfy.registry.persistence.repository;

import com.scoolfy.registry.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByIdentification(String identification);

    @Transactional
    @Modifying
    @Query("update User u set u.username = ?1 where u.id = ?2")
    int updateUserName(String username, @NonNull Integer id);
}