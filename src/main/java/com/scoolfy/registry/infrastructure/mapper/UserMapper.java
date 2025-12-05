package com.scoolfy.registry.infrastructure.mapper;

import com.scoolfy.registry.application.command.RegisterStudentCommand;
import com.scoolfy.registry.domain.model.dto.UserDto;
import com.scoolfy.registry.domain.model.request.RegistryStudentRequest;
import com.scoolfy.registry.persistence.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = {Instant.class})
public interface UserMapper {

    RegisterStudentCommand toCommand(User users);

    List<UserDto> toUserDtoList(List<User> userDto);

    @Mapping(target = "username", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "identification", source = "idStudent")
    @Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
    User toEntity(RegisterStudentCommand cmd);

    List<User> toUserEntityList(List<UserDto> userDtos);

    @Mapping(target = "createdAt", expression = "java(Instant.now())")
    @Mapping(target = "active", expression = "java(Boolean.TRUE)")
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "identification", source = "idStudent")
    User toUserEntityRequest(RegistryStudentRequest request);
}
