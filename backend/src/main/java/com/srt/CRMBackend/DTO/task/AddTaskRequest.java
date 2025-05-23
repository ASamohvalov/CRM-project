package com.srt.CRMBackend.DTO.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class AddTaskRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private int numberOfPoints;
    @NotBlank
    private LocalDate deadline;
    @NotNull
    private UUID taskCategoryId;
}
