package com.scoolfy.registry.application.dto;

public record RegisteredStudentDto(
        Integer studentId,
        Integer userId,
        String username
) {
}