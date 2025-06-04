package com.srt.CRMBackend.DTO.request;

import com.srt.CRMBackend.DTO.employee.EmployeeDTO;
import com.srt.CRMBackend.DTO.task.TaskResponse;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TaskExecutionRequestDTO {
    private UUID id;
    private EmployeeDTO employee;
    private TaskResponse task;
}
