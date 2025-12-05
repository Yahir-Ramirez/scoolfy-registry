package com.scoolfy.registry.infrastructure.mapper;

import com.scoolfy.registry.application.command.RegisterStudentCommand;
import com.scoolfy.registry.domain.model.dto.StudentDto;
import com.scoolfy.registry.domain.model.request.RegistryStudentRequest;
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

    @Mapping(target = "firstName", source = "idUser.firstName")
    @Mapping(target = "secondName", source = "idUser.secondName")
    @Mapping(target = "firstLastName", source = "idUser.firstLastName")
    @Mapping(target = "secondLastName", source = "idUser.secondLastName")
    @Mapping(target = "email", source = "idUser.email")
    @Mapping(target = "idStudent", source = "idUser.identification")
    @Mapping(target = "grade", source = "gradeGroup.gradeUnit")
    @Mapping(target = "group", source = "gradeGroup.groupUnit")
    RegistryStudentRequest toRequest(Student student);

    List<RegistryStudentRequest> toRequestList(List<Student> students);
}
