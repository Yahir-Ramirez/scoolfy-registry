package com.scoolfy.registry.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "grade", schema = "control_access")
public class Grade {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "GRADE_UNIT", nullable = false, length = 3)
    private String gradeUnit;

    @Column(name = "GROUP_UNIT", nullable = false, length = 3)
    private String groupUnit;

    @Column(name = "DEFAULT_ENTRY_TIME")
    private LocalTime defaultEntryTime;

}