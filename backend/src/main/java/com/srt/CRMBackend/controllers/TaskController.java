package com.srt.CRMBackend.controllers;

import com.srt.CRMBackend.DTO.task.TaskCategoryRequest;
import com.srt.CRMBackend.DTO.task.AddTaskRequest;
import com.srt.CRMBackend.DTO.task.TaskCategoryResponse;
import com.srt.CRMBackend.services.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
@Tag(name = "работа с задачами", description = "методы доступны админам и менеджерам")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/add")
    public Map<String, String> addTask(@Valid @RequestBody AddTaskRequest request) {
        taskService.addTask(request);
        return Map.of("message", "задача успешно добавлена");
    }

    @DeleteMapping("/delete/{taskId}")
    public Map<String, String> deleteTask(@PathVariable UUID taskId) {
        taskService.deleteTask(taskId);
        return Map.of("message", "задача успешно удалена");
    }

    @PostMapping("/add_task_category")
    public Map<String, String> addTaskCategory(@Valid @RequestBody TaskCategoryRequest request) {
        taskService.addTaskCategory(request);
        return Map.of("message", "категория задачи успешно добавлена");
    }

    @GetMapping("/categories/get_all")
    public List<TaskCategoryResponse> getAllTaskCategories() {
        return taskService.getAllTaskCategories();
    }
}
