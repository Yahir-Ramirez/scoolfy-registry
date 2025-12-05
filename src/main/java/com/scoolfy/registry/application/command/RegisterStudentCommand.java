package com.scoolfy.registry.application.command;

public record RegisterStudentCommand(
        String firstName,
        String secondName,
        String firstLastName,
        String secondLastName,
        String idStudent,
        String email,
        String grade,
        String group
) {
}