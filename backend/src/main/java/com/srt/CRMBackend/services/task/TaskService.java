package com.srt.CRMBackend.services;

import com.srt.CRMBackend.DTO.task.TaskCategoryRequest;
import com.srt.CRMBackend.DTO.task.TaskRequest;
import com.srt.CRMBackend.DTO.task.TaskCategoryDTO;
import com.srt.CRMBackend.DTO.task.TaskResponse;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    void addTask(TaskRequest request);
    void deleteTask(UUID taskId);

    void addTaskCategory(TaskCategoryRequest request);

    List<TaskCategoryDTO> getAllTaskCategories();
    List<TaskResponse> getAllTasks();
}
