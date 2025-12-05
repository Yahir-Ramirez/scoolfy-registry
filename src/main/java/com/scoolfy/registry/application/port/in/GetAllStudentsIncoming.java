package com.scoolfy.registry.application.port.in;

import com.scoolfy.registry.domain.model.request.RegistryStudentRequest;

import java.util.List;

public interface GetAllStudentsIncoming {
    List<RegistryStudentRequest> getAll();
}
