package com.scoolfy.registry.domain.port.out;

import com.scoolfy.registry.application.command.RegisterStudentCommand;
import com.scoolfy.registry.application.dto.RegisteredStudentDto;
import com.scoolfy.registry.domain.model.request.RegistryStudentRequest;

public interface RegisterStudentPort {

    RegisteredStudentDto registerStudent(RegisterStudentCommand request);
}
