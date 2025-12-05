package com.scoolfy.registry.infrastructure.web.controller;

import com.scoolfy.registry.application.command.RegisterStudentCommand;
import com.scoolfy.registry.application.dto.RegisteredStudentDto;
import com.scoolfy.registry.application.port.in.RegisterStudentIncoming;
import com.scoolfy.registry.domain.model.request.RegistryStudentRequest;
import com.scoolfy.registry.persistence.entity.Student;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/registry")
@RestController(value = "registryController")
public class RegistryController {

    private final RegisterStudentIncoming registerStudentIncoming;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<RegisteredStudentDto> registry(@Valid @RequestBody final RegistryStudentRequest request) {
        RegisterStudentCommand cmd = new RegisterStudentCommand(
                normalize(request.firstName()),
                normalize(request.secondName()),
                normalize(request.firstLastName()),
                normalize(request.secondLastName()),
                normalize(request.idStudent()),
                normalize(request.email()),
                normalize(request.grade()),
                normalize(request.group())
        );

        RegisteredStudentDto result = registerStudentIncoming.registerStudent(cmd);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    private String normalize(final String value) {
        return (value == null || value.isBlank()) ? null : value;
    }

}
