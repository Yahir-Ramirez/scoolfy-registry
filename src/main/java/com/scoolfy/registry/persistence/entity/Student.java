package com.scoolfy.registry.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "student", schema = "control_access", indexes = {
        @Index(name = "ID_USER", columnList = "ID_USER")
}, uniqueConstraints = {
        @UniqueConstraint(name = "GRADE_GROUP", columnNames = {"GRADE_GROUP"})
})
public class Student {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USER", nullable = false)
    private User idUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "GRADE_GROUP", nullable = false)
    private Grade gradeGroup;

}