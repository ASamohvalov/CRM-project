package com.srt.CRMBackend.DTO.task;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TaskCategoryResponse {
    private UUID id;
    private String name;
    private String description;
}
