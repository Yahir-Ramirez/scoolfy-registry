package com.scoolfy.registry.domain.port.out;

import com.scoolfy.registry.domain.model.request.RegistryStudentRequest;

import java.util.List;

public interface GetAllStudentsPort {
    List<RegistryStudentRequest> getAll();
}
