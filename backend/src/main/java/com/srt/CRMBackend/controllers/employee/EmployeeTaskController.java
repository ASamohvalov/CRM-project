package com.srt.CRMBackend.controllers.employee;

import com.srt.CRMBackend.DTO.task.GetTaskEmployeeRequests;
import com.srt.CRMBackend.services.employee.EmployeeTaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/task/employee")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "работа с задачами (для сотрудников)", description = "методы доступны всем авторизованным работникам")
public class EmployeeTaskController {
    private final EmployeeTaskService employeeTaskService;

    @Operation(description = "после взятии задачи отправляется заявка на подтверждение")
    @GetMapping("/take/{taskId}")
    public Map<String, String> takeTask(@PathVariable UUID taskId) {
        log.info("call take task endpoint");
        employeeTaskService.takeTask(taskId);
        return Map.of("message", "заявка на получение задачи отправлена");
    }

    @Operation(description = "получение всех заявок на выполение задачи у работника")
    @GetMapping("get_all_requests")
    public List<GetTaskEmployeeRequests> getAllRequests() {
        log.info("call get all requests");
        return employeeTaskService.getAllRequests();
    }
}
