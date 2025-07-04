package com.srt.CRMBackend.services.employee.impl;

import com.srt.CRMBackend.DTO.task.GetTaskEmployeeRequests;
import com.srt.CRMBackend.DTO.task.TaskResponse;
import com.srt.CRMBackend.auth.UserDetailsImpl;
import com.srt.CRMBackend.exceptions.CrmBadRequestException;
import com.srt.CRMBackend.mappers.TaskExecutionRequestMapper;
import com.srt.CRMBackend.mappers.TaskMapper;
import com.srt.CRMBackend.models.employees.Employee;
import com.srt.CRMBackend.models.tasks.*;
import com.srt.CRMBackend.repositories.tasks.EmployeeTaskRepository;
import com.srt.CRMBackend.repositories.tasks.TaskExecutionRequestRepository;
import com.srt.CRMBackend.repositories.tasks.TaskRepository;
import com.srt.CRMBackend.services.employee.EmployeeTaskService;
import jakarta.transaction.Transactional;
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
    private final TaskMapper taskMapper;

    @Override
    @Transactional
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

        Task task = taskRepository.findById(taskId).orElseThrow(RuntimeException::new);
        task.setStatus(TaskStatus.IN_PROGRESS);
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

    @Override
    public List<TaskResponse> getAllTasks() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return employeeTaskRepository.findAllTasksByEmployeeId(userDetails.getEmployee().getId())
                .stream().map((t) -> taskMapper.toTaskResponse(t.getTask())).toList();
    }

    @Override
    @Transactional
    public void sendRequestForReview(UUID taskId) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        List<EmployeeTask> tasks = employeeTaskRepository.findAllTasksByEmployeeId(userDetails.getEmployee().getId());
        for (EmployeeTask employeeTask : tasks) {
            System.out.println(employeeTask.getTask().getId());
            if (employeeTask.getTask().getId().equals(taskId)) {
                employeeTask.setExecutionStatus(ExecutionStatus.SUBMITTED_FOR_REVIEW);
                return;
            }
        }
        throw new CrmBadRequestException("данная задача не найдена у пользователя");
    }
}
