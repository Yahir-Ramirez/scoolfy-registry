package com.scoolfy.registry.persistence.adapter;

import com.scoolfy.registry.domain.model.request.RegistryStudentRequest;
import com.scoolfy.registry.domain.port.out.GetAllStudentsPort;
import com.scoolfy.registry.infrastructure.mapper.StudentMapper;
import com.scoolfy.registry.persistence.entity.Student;
import com.scoolfy.registry.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentAdapter implements GetAllStudentsPort {

    private final StudentRepository studentRepository;
    private final StudentMapper mapper;

    @Override
    public List<RegistryStudentRequest> getAll() {
        List<Student> students = studentRepository.findAll();
        return mapper.toRequestList(students);
    }
}
