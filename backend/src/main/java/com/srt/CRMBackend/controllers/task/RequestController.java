package com.srt.CRMBackend.controllers.task;

import com.srt.CRMBackend.DTO.request.EmployeeTaskDTO;
import com.srt.CRMBackend.DTO.request.TaskExecutionRequestDTO;
import com.srt.CRMBackend.services.task.RequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/task/requests")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "работа с заявками", description = "все методы доступны менеджерам и админам")
public class RequestController {
    private final RequestService requestService;

    @GetMapping("/get_unaccepted_execution_requests")
    public List<TaskExecutionRequestDTO> getUnacceptedExecutionRequests() {
        log.info("call - get unaccepted execution requests");
        return requestService.getUnacceptedExecutionRequests();
    }

    @GetMapping("/accept_execution_request/{requestId}")
    public Map<String, String> acceptExecutionRequest(@PathVariable UUID requestId) {
        log.info("call - accept execution request");
        requestService.acceptExecutionRequest(requestId);
        return Map.of("message", "запрос на выполнение задачи принят");
    }

    @Operation(description = "получение всех заявок на проверку задачи")
    @GetMapping("/get_employee_tasks_submitted_for_review")
    public List<EmployeeTaskDTO> getEmployeeTasksSubmittedForReview() {
        return requestService.getEmployeeTasksSubmittedForReview();
    }

    @Operation(description = "подтверждение выполнения задачи и добавление очков сотруднику")
    @GetMapping("/accept_task_submitted_for_review/{employeeTaskId}")
    public Map<String, String> acceptTaskSubmittedForReview(@PathVariable UUID employeeTaskId) {
        log.info("call - accept_task_submitted_for_review");
        requestService.acceptTaskSubmittedForReview(employeeTaskId);
        return Map.of("message", "запрос на сдачу задачи принят");
    }
}
