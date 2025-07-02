package com.srt.CRMBackend.services.task.impl;

import com.srt.CRMBackend.DTO.request.EmployeeTaskDTO;
import com.srt.CRMBackend.DTO.request.TaskExecutionRequestDTO;
import com.srt.CRMBackend.exceptions.CrmBadRequestException;
import com.srt.CRMBackend.mappers.EmployeeMapper;
import com.srt.CRMBackend.mappers.TaskMapper;
import com.srt.CRMBackend.models.employees.Employee;
import com.srt.CRMBackend.models.employees.Point;
import com.srt.CRMBackend.models.tasks.*;
import com.srt.CRMBackend.repositories.employee.PointRepository;
import com.srt.CRMBackend.repositories.tasks.EmployeeTaskRepository;
import com.srt.CRMBackend.repositories.tasks.TaskExecutionRequestRepository;
import com.srt.CRMBackend.repositories.tasks.TaskRepository;
import com.srt.CRMBackend.services.employee.EmployeeTaskService;
import com.srt.CRMBackend.services.task.RequestService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final TaskExecutionRequestRepository taskExecutionRequestRepository;
    private final EmployeeMapper employeeMapper;
    private final TaskMapper taskMapper;
    private final EmployeeTaskService employeeTaskService;
    private final EmployeeTaskRepository employeeTaskRepository;
    private final TaskRepository taskRepository;
    private final PointRepository pointRepository;

    @Override
    public List<TaskExecutionRequestDTO> getUnacceptedExecutionRequests() {
        return taskExecutionRequestRepository.findAllUnacceptedWithEmployeeAndTask().stream()
                .map(el -> TaskExecutionRequestDTO.builder()
                        .id(el.getId())
                        .employee(employeeMapper.toEmployeeDTO(el.getEmployee()))
                        .task(taskMapper.toTaskResponse(el.getTask())).build()
                ).toList();
    }

    @Override
    @Transactional
    public void acceptExecutionRequest(UUID requestId) {
        TaskExecutionRequest taskExecutionRequest = taskExecutionRequestRepository.findById(requestId)
                .orElseThrow(() -> new CrmBadRequestException("неправильный идентификатор"));
        taskExecutionRequest.setAccepted(true);

        employeeTaskService.saveEmployeeTask(
                taskExecutionRequest.getEmployee().getId(),
                taskExecutionRequest.getTask().getId()
        );
    }

    @Override
    @Transactional
    public List<EmployeeTaskDTO> getEmployeeTasksSubmittedForReview() {
        return employeeTaskRepository.findByExecutionStatus(ExecutionStatus.SUBMITTED_FOR_REVIEW)
                .stream().map((et) -> EmployeeTaskDTO.builder()
                        .id(et.getId())
                        .task(taskMapper.toTaskResponse(et.getTask()))
                        .employee(employeeMapper.toEmployeeDTO(et.getEmployee()))
                        .build())
                .toList();
    }

    @Override
    @Transactional
    public void acceptTaskSubmittedForReview(UUID employeeTaskId) {
        EmployeeTask employeeTask = employeeTaskRepository.findById(employeeTaskId)
                .orElseThrow(() -> new CrmBadRequestException("некорректный идентификатор"));
        employeeTask.setExecutionStatus(ExecutionStatus.ACCEPTED);

        Task task = taskRepository.findById(employeeTask.getTask().getId())
                .orElseThrow(RuntimeException::new);
        task.setStatus(TaskStatus.COMPLETED);

        Point point = pointRepository.findByEmployeeId(employeeTask.getEmployee().getId())
                .orElseGet(() ->
                    pointRepository.save(Point.builder()
                            .employee(employeeTask.getEmployee())
                            .total(0).build())
                );
        point.setTotal(point.getTotal() + task.getNumberOfPoints());
        point.setLastUpdate(Date.from(Instant.now()));
    }
}
