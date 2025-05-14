package com.srt.CRMBackend.controllers;

import com.srt.CRMBackend.DTO.task.AddTaskRequest;
import com.srt.CRMBackend.services.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
}
