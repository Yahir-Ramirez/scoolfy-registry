package com.scoolfy.registry.infrastructure.web.controller;

import com.scoolfy.registry.application.port.in.GetAllStudentsIncoming;
import com.scoolfy.registry.domain.model.request.RegistryStudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registry") //TODO: Aquí me toca ajustarlo para el path correcto para este controller
@RequiredArgsConstructor
public class StudentController {

    private final GetAllStudentsIncoming getAllStudentsIncoming;

    @GetMapping
    public ResponseEntity<List<RegistryStudentRequest>> getAll() {
        return ResponseEntity.ok(getAllStudentsIncoming.getAll());
    }
}
