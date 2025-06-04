package com.srt.CRMBackend.services.employee.impl;

import com.srt.CRMBackend.auth.UserDetailsImpl;
import com.srt.CRMBackend.models.employees.Employee;
import com.srt.CRMBackend.models.tasks.EmployeeTask;
import com.srt.CRMBackend.models.tasks.Task;
import com.srt.CRMBackend.models.tasks.TaskExecutionRequest;
import com.srt.CRMBackend.repositories.tasks.EmployeeTaskRepository;
import com.srt.CRMBackend.repositories.tasks.TaskExecutionRequestRepository;
import com.srt.CRMBackend.services.employee.EmployeeTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeTaskServiceImpl implements EmployeeTaskService {
    private final TaskExecutionRequestRepository taskExecutionRequestRepository;
    private final EmployeeTaskRepository employeeTaskRepository;

    @Override
    public void takeTask(UUID taskId) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        TaskExecutionRequest taskExecutionRequest = TaskExecutionRequest.builder()
                .task(new Task(taskId))
                .employee(userDetails.getEmployee()).build();
        taskExecutionRequestRepository.save(taskExecutionRequest);
    }

    public void saveEmployeeTask(UUID employeeId, UUID taskId) {
        employeeTaskRepository.save(EmployeeTask.builder()
                .employee(new Employee(employeeId))
                .task(new Task(taskId)).build());
    }
}
