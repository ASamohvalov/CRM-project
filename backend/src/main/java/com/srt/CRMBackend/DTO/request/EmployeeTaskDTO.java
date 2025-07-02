package com.srt.CRMBackend.DTO.request;

import com.srt.CRMBackend.DTO.employee.EmployeeDTO;
import com.srt.CRMBackend.DTO.task.TaskResponse;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class EmployeeTaskDTO {
    private UUID id;
    private TaskResponse task;
    private EmployeeDTO employee;
}
