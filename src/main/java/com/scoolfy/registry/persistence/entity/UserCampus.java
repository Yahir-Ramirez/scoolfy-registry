package com.scoolfy.registry.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "user_campus", schema = "control_access", indexes = {
        @Index(name = "ID_CAMPUS", columnList = "ID_CAMPUS")
}, uniqueConstraints = {
        @UniqueConstraint(name = "ID_USER", columnNames = {"ID_USER", "ID_CAMPUS"})
})
public class UserCampus {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_USER", nullable = false)
    private User idUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_CAMPUS", nullable = false)
    private Campus idCampus;

    @ColumnDefault("0")
    @Column(name = "TOTAL_ACCESS")
    private Boolean totalAccess;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "ASSIGNED_AT")
    private Instant assignedAt;

}