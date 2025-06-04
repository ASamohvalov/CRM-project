package com.srt.CRMBackend.services.task;

import com.srt.CRMBackend.DTO.request.TaskExecutionRequestDTO;

import java.util.List;
import java.util.UUID;

public interface RequestService {
    List<TaskExecutionRequestDTO> getUnacceptedExecutionRequests();
    void acceptExecutionRequest(UUID requestId);
}
