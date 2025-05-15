package com.srt.CRMBackend.controllers;

import com.srt.CRMBackend.DTO.task.AddTaskRequest;
import com.srt.CRMBackend.services.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
@Tag(name = "работа с задачами", description = "методы доступны админам и менеджерам")
public class TaskController {
    private final TaskService taskService;

//    @PostMapping("/add")
//    public ResponseEntity<> addTask(@Valid @RequestBody AddTaskRequest request) {
//        taskService.addTask(request);
//        return ResponseEntity.created(
//    }

    @DeleteMapping("/delete/{taskId}")
    public void deleteTask(@PathVariable UUID taskId) {

    }
}
