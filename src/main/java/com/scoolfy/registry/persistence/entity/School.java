package com.scoolfy.registry.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "school", schema = "control_access", uniqueConstraints = {
        @UniqueConstraint(name = "NAME", columnNames = {"NAME"}),
        @UniqueConstraint(name = "NIT", columnNames = {"NIT"})
})
public class School {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "NIT", nullable = false, length = 20)
    private String nit;

    @Column(name = "CREATED_AT")
    private Instant createdAt;

}