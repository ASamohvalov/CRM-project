package com.srt.CRMBackend.mappers;

import com.srt.CRMBackend.DTO.task.GetTaskEmployeeRequests;
import com.srt.CRMBackend.models.tasks.TaskExecutionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskExecutionRequestMapper {
    GetTaskEmployeeRequests toGetTaskEmployeeRequests(TaskExecutionRequest taskExecutionRequest);
}
