package com.scoolfy.registry.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "user_role", schema = "control_access", indexes = {
        @Index(name = "ID_ROLE", columnList = "ID_ROLE")
})
public class UserRole {
    @EmbeddedId
    private UserRoleId id;

    @MapsId("idUser")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_USER", nullable = false)
    private User idUser;

    @MapsId("idRole")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_ROLE", nullable = false)
    private Role idRole;

}