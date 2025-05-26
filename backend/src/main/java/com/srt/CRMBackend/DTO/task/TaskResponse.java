package com.srt.CRMBackend.DTO.task;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class TaskResponse {
    private UUID id;
    private String name;
    private String description;
    private int numberOfPoints;
    private LocalDate deadline;
    private TaskCategoryDTO category;
}
