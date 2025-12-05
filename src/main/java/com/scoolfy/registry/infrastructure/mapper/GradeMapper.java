package com.scoolfy.registry.infrastructure.mapper;

import com.scoolfy.registry.domain.model.dto.GradeDto;
import com.scoolfy.registry.persistence.entity.Grade;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GradeMapper {

    Grade toGrade(GradeDto gradeDto);

    List<Grade> toGradeList(List<GradeDto> gradeDtos);

    GradeDto toGradeDto(Grade grade);

    List<GradeDto> toGradeDtoList(List<Grade> grades);
}
