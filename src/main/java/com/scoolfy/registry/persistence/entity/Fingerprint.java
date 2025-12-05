package com.scoolfy.registry.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "fingerprint", schema = "control_access", indexes = {
        @Index(name = "ID_USER", columnList = "ID_USER")
})
public class Fingerprint {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USER", nullable = false)
    private User idUser;

    @Lob
    @Column(name = "FINGER")
    private String finger;

    @Lob
    @Column(name = "TEMPLATE", nullable = false)
    private String template;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "REGISTRY_DATE")
    private Instant registryDate;

}