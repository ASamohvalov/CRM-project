package com.srt.CRMBackend.services.employee.impl;

import com.srt.CRMBackend.DTO.task.GetTaskEmployeeRequests;
import com.srt.CRMBackend.auth.UserDetailsImpl;
import com.srt.CRMBackend.exceptions.CrmBadRequestException;
import com.srt.CRMBackend.mappers.TaskExecutionRequestMapper;
import com.srt.CRMBackend.models.employees.Employee;
import com.srt.CRMBackend.models.tasks.EmployeeTask;
import com.srt.CRMBackend.models.tasks.Task;
import com.srt.CRMBackend.models.tasks.TaskExecutionRequest;
import com.srt.CRMBackend.repositories.tasks.EmployeeTaskRepository;
import com.srt.CRMBackend.repositories.tasks.TaskExecutionRequestRepository;
import com.srt.CRMBackend.repositories.tasks.TaskRepository;
import com.srt.CRMBackend.services.employee.EmployeeTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeTaskServiceImpl implements EmployeeTaskService {
    private final TaskExecutionRequestRepository taskExecutionRequestRepository;
    private final EmployeeTaskRepository employeeTaskRepository;
    private final TaskExecutionRequestMapper taskExecutionRequestMapper;
    private final TaskRepository taskRepository;

    @Override
    public void takeTask(UUID taskId) {
        if (!taskRepository.existsById(taskId)) {
            throw new CrmBadRequestException("некорректный идентификатор");
        }

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        TaskExecutionRequest taskExecutionRequest = TaskExecutionRequest.builder()
                .task(new Task(taskId))
                .employee(userDetails.getEmployee()).build();
        taskExecutionRequestRepository.save(taskExecutionRequest);
    }

    @Override
    public void saveEmployeeTask(UUID employeeId, UUID taskId) {
        employeeTaskRepository.save(EmployeeTask.builder()
                .employee(new Employee(employeeId))
                .task(new Task(taskId)).build());
    }

    @Override
    public List<GetTaskEmployeeRequests> getAllRequests() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return taskExecutionRequestRepository.findAllByEmployeeIdWithTask(
                        userDetails.getEmployee().getId()).stream()
                .map(taskExecutionRequestMapper::toGetTaskEmployeeRequests)
                .collect(Collectors.toList());
    }
}
