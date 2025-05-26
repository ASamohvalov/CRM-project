package com.srt.CRMBackend.controllers.task;

import com.srt.CRMBackend.DTO.task.TaskCategoryRequest;
import com.srt.CRMBackend.DTO.task.TaskRequest;
import com.srt.CRMBackend.services.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
@Tag(name = "редактирование и добавление задач", description = "методы доступны админам и менеджерам")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/add")
    public Map<String, String> addTask(@Valid @RequestBody TaskRequest request) {
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
}
