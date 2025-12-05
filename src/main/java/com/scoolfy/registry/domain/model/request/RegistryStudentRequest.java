package com.scoolfy.registry.domain.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

public record RegistryStudentRequest(
        @NonNull
        @NotBlank(message = "El primer nombre es obligatorio")
        String firstName,
        String secondName,

        @NonNull
        @NotBlank(message = "El primer apellido es obligatorio")
        String firstLastName,
        String secondLastName,

        @NonNull
        @NotBlank(message = "La identificación es obligatoria")
        String idStudent,

        @NonNull
        @NotBlank(message = "El email es obligatorio")
        String email,

        @NonNull
        @NotBlank(message = "El grado es obligatorio")
        String grade,

        @NonNull
        @NotBlank(message = "El grupo es obligatorio")
        String group
) {
}
