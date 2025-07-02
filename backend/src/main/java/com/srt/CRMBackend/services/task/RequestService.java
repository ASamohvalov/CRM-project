package com.srt.CRMBackend.services.task;

import com.srt.CRMBackend.DTO.request.EmployeeTaskDTO;
import com.srt.CRMBackend.DTO.request.TaskExecutionRequestDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface RequestService {
    List<TaskExecutionRequestDTO> getUnacceptedExecutionRequests();
    void acceptExecutionRequest(UUID requestId);

    List<EmployeeTaskDTO> getEmployeeTasksSubmittedForReview();
    void acceptTaskSubmittedForReview(UUID employeeTaskId);
}
