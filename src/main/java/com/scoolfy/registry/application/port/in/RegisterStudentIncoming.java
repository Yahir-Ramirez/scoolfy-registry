package com.scoolfy.registry.application.port.in;

import com.scoolfy.registry.application.command.RegisterStudentCommand;
import com.scoolfy.registry.application.dto.RegisteredStudentDto;
import com.scoolfy.registry.domain.model.request.RegistryStudentRequest;

@FunctionalInterface
public interface RegisterStudentIncoming {

    RegisteredStudentDto registerStudent(RegisterStudentCommand request);

}
