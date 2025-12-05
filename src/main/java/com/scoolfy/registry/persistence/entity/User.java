package com.scoolfy.registry.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "user", schema = "control_access", uniqueConstraints = {
        @UniqueConstraint(name = "EMAIL", columnNames = {"EMAIL"}),
        @UniqueConstraint(name = "IDENTIFICATION", columnNames = {"IDENTIFICATION"})
})
public class User {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FIRST_NAME", nullable = false, length = 100)
    private String firstName;

    @Column(name = "SECOND_NAME", nullable = true, length = 100)
    private String secondName;

    @Column(name = "FIRST_LAST_NAME", nullable = false, length = 100)
    private String firstLastName;

    @Column(name = "SECOND_LAST_NAME", nullable = true, length = 100)
    private String secondLastName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "USERNAME", nullable = true, length = 50)
    private String username;

    @Column(name = "IDENTIFICATION", nullable = false, length = 50)
    private String identification;

    @Column(name = "PASSWORD_HASH", nullable = true)
    private String passwordHash;

    @ColumnDefault("1")
    @Column(name = "ACTIVE")
    private Boolean active;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "CREATED_AT")
    private Instant createdAt;
}