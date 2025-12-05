package com.scoolfy.registry.persistence.adapter;

import com.scoolfy.registry.application.command.RegisterStudentCommand;
import com.scoolfy.registry.application.dto.RegisteredStudentDto;
import com.scoolfy.registry.constant.Constant;
import com.scoolfy.registry.domain.model.dto.UserDto;
import com.scoolfy.registry.domain.model.request.RegistryStudentRequest;
import com.scoolfy.registry.domain.port.out.RegisterStudentPort;
import com.scoolfy.registry.infrastructure.mapper.StudentMapper;
import com.scoolfy.registry.infrastructure.mapper.UserMapper;
import com.scoolfy.registry.persistence.entity.Grade;
import com.scoolfy.registry.persistence.entity.Student;
import com.scoolfy.registry.persistence.entity.User;
import com.scoolfy.registry.persistence.repository.GradeRepository;
import com.scoolfy.registry.persistence.repository.StudentRepository;
import com.scoolfy.registry.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@RequiredArgsConstructor
public class RegistryAdapter implements RegisterStudentPort {

    private final static Logger LOGGER = LoggerFactory.getLogger(RegistryAdapter.class);

    private final UserRepository userRepository;
    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final UserMapper userMapper;
    private final StudentMapper studentMapper;

    @Override
    @Transactional
    public RegisteredStudentDto registerStudent(RegisterStudentCommand cmd) {

        // Crear Usuario
        User user = userMapper.toEntity(cmd);
        user = userRepository.save(user);

        String username = createUserName(cmd.firstName(), cmd.firstLastName(), user.getId().toString());
        int isUpdated = userRepository.updateUserName(username, user.getId());

        if (isUpdated == 0) {
            throw new RuntimeException("Error al actualizar el nombre de usuario");
        }

        // Buscar o crear grade
        Grade grade = gradeRepository.findByGradeUnitAndGroupUnit(cmd.grade(), cmd.group())
                    .orElseGet(() -> {
                    Grade g = new Grade();
                    g.setGradeUnit(cmd.grade());
                    g.setGroupUnit(cmd.group());
                    g.setDefaultEntryTime(Constant.DEFAULT_ENTRY_TIME);
                    return gradeRepository.save(g);
                });

        // Crear Student
        Student student = studentMapper.toEntity(cmd, user, grade);
        student = studentRepository.save(student);

        LOGGER.info("Estudiante {} creado exitósamente", student.getId());

        return new RegisteredStudentDto(
                student.getId(),
                user.getId(),
                username
        );
    }

    private String createUserName(final String firstName, final String firstLastName, final String idUser) {
        return String.format("%s.%s%s", firstName.replaceAll("\\s+", "").toLowerCase(),
                firstLastName.replaceAll("\\s+", "").toLowerCase(), idUser);
    }
}
