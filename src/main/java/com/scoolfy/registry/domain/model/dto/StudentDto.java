package com.scoolfy.registry.domain.model.dto;

import com.scoolfy.registry.persistence.entity.Grade;
import com.scoolfy.registry.persistence.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Integer id;
    private UserDto idUser;
    private GradeDto gradeGroup;
}
