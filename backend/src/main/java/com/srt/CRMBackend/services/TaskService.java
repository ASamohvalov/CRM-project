package com.srt.CRMBackend.services;

import com.srt.CRMBackend.DTO.task.AddTaskRequest;

public interface TaskService {
    void addTask(AddTaskRequest request);
}
