package com.srt.CRMBackend.services;

import com.srt.CRMBackend.DTO.task.TaskCategoryRequest;
import com.srt.CRMBackend.DTO.task.AddTaskRequest;
import com.srt.CRMBackend.DTO.task.TaskCategoryResponse;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    void addTask(AddTaskRequest request);
    void deleteTask(UUID taskId);

    void addTaskCategory(TaskCategoryRequest request);
    List<TaskCategoryResponse> getAllTaskCategories();
}
