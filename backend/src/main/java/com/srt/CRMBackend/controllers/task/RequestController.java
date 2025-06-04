package com.srt.CRMBackend.controllers.task;

import com.srt.CRMBackend.DTO.request.TaskExecutionRequestDTO;
import com.srt.CRMBackend.services.task.RequestService;
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
}
