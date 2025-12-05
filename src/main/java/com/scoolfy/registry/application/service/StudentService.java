package com.scoolfy.registry.application.service;

import com.scoolfy.registry.application.port.in.GetAllStudentsIncoming;
import com.scoolfy.registry.domain.model.request.RegistryStudentRequest;
import com.scoolfy.registry.domain.port.out.GetAllStudentsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements GetAllStudentsIncoming {
    private final GetAllStudentsPort port;

    @Override
    public List<RegistryStudentRequest> getAll() {
        return port.getAll();
    }
}
