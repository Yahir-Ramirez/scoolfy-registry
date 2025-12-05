package com.scoolfy.registry.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "campus", schema = "control_access", indexes = {
        @Index(name = "ID_SCHOOL", columnList = "ID_SCHOOL")
}, uniqueConstraints = {
        @UniqueConstraint(name = "NAME", columnNames = {"NAME", "ID_SCHOOL", "NIT"})
})
public class Campus {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_SCHOOL", nullable = false)
    private School idSchool;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "SHORT_NAME", nullable = false, length = 100)
    private String shortName;

    @Column(name = "NIT", nullable = false, length = 20)
    private String nit;

    @Column(name = "DIRECCION", length = 200)
    private String direccion;

    @Column(name = "TELEFONO", length = 20)
    private String telefono;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "OPERATIVE_STATUS", length = 20)
    private String operativeStatus;

}