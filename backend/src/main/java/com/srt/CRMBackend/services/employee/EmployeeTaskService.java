package com.srt.CRMBackend.services.employee;

import com.srt.CRMBackend.DTO.task.GetTaskEmployeeRequests;
import com.srt.CRMBackend.DTO.task.TaskResponse;

import java.util.List;
import java.util.UUID;

public interface EmployeeTaskService {
    void takeTask(UUID taskId);
    void saveEmployeeTask(UUID employeeId, UUID taskId);

    List<GetTaskEmployeeRequests> getAllRequests();
    List<TaskResponse> getAllTasks();

}
