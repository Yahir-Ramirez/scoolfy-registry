package com.scoolfy.registry.infrastructure.mapper;

import com.scoolfy.registry.application.command.RegisterStudentCommand;
import com.scoolfy.registry.domain.model.dto.StudentDto;
import com.scoolfy.registry.persistence.entity.Grade;
import com.scoolfy.registry.persistence.entity.Student;
import com.scoolfy.registry.persistence.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, GradeMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    StudentDto toStudentDto(Student student);

    List<StudentDto> toStudentDtoList(List<Student> students);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idUser", source = "user")
    @Mapping(target = "gradeGroup", source = "grade")
    Student toEntity(RegisterStudentCommand cmd, User user, Grade grade);

    List<Student> toStudentList(List<StudentDto> studentDtos);
}
