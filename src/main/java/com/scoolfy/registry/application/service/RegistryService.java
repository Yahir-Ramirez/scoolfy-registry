package com.scoolfy.registry.application.service;

import com.scoolfy.registry.application.command.RegisterStudentCommand;
import com.scoolfy.registry.application.dto.RegisteredStudentDto;
import com.scoolfy.registry.application.port.in.RegisterStudentIncoming;
import com.scoolfy.registry.domain.model.request.RegistryStudentRequest;
import com.scoolfy.registry.domain.port.out.RegisterStudentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistryService implements RegisterStudentIncoming {

    private final RegisterStudentPort registerStudentPort;

    /**
     * {@inheritDoc}
    **/
    @Override
    public RegisteredStudentDto registerStudent(RegisterStudentCommand request) {
        return registerStudentPort.registerStudent(request);
    }
}
