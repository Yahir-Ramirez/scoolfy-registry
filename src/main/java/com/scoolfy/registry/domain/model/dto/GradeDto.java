package com.scoolfy.registry.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GradeDto {
    private Integer id;
    private String gradeUnit;
    private String groupUnit;
    private LocalTime defaultEntryTime;
}
