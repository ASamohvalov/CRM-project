package com.srt.CRMBackend.controllers.task;

import com.srt.CRMBackend.DTO.task.TaskCategoryDTO;
import com.srt.CRMBackend.DTO.task.TaskResponse;
import com.srt.CRMBackend.services.task.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task/get")
@RequiredArgsConstructor
@Tag(name = "получение задач", description = "методы доступны всем авторизованным работникам")
public class GetTaskController {
    private final TaskService taskService;

    @GetMapping
    public List<TaskResponse> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/task_categories")
    public List<TaskCategoryDTO> getAllTaskCategories() {
        return taskService.getAllTaskCategories();
    }
}
