package com.srt.CRMBackend.DTO.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
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
    private Date deadlineFrom;
    @NotBlank
    private Date deadlineTo;
    @NotNull
    private UUID taskCategoryId;
}
