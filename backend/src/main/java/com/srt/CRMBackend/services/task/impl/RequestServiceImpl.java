package com.srt.CRMBackend.services.task.impl;

import com.srt.CRMBackend.DTO.request.TaskExecutionRequestDTO;
import com.srt.CRMBackend.exceptions.CrmBadRequestException;
import com.srt.CRMBackend.mappers.EmployeeMapper;
import com.srt.CRMBackend.mappers.TaskMapper;
import com.srt.CRMBackend.models.tasks.TaskExecutionRequest;
import com.srt.CRMBackend.repositories.tasks.TaskExecutionRequestRepository;
import com.srt.CRMBackend.services.employee.EmployeeTaskService;
import com.srt.CRMBackend.services.task.RequestService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final TaskExecutionRequestRepository taskExecutionRequestRepository;
    private final EmployeeMapper employeeMapper;
    private final TaskMapper taskMapper;
    private final EmployeeTaskService employeeTaskService;

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
}
