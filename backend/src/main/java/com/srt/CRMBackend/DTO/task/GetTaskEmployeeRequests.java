package com.srt.CRMBackend.DTO.task;

import lombok.Data;

import java.util.UUID;

@Data
public class GetTaskEmployeeRequests {
    private UUID id;
    private TaskResponse task;
    private boolean isAccepted;
}
