package com.srt.CRMBackend.services;

import com.srt.CRMBackend.DTO.task.AddTaskRequest;

import java.util.UUID;

public interface TaskService {
    void addTask(AddTaskRequest request);
    void deleteTask(UUID taskId);
}
