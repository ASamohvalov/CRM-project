package com.srt.CRMBackend.services.impl;

import com.srt.CRMBackend.DTO.task.TaskCategoryRequest;
import com.srt.CRMBackend.DTO.task.AddTaskRequest;
import com.srt.CRMBackend.DTO.task.TaskCategoryResponse;
import com.srt.CRMBackend.exceptions.CrmBadRequestException;
import com.srt.CRMBackend.models.tasks.Task;
import com.srt.CRMBackend.models.tasks.TaskCategory;
import com.srt.CRMBackend.models.tasks.TaskStatus;
import com.srt.CRMBackend.repositories.tasks.TaskRepository;
import com.srt.CRMBackend.repositories.tasks.TaskCategoryRepository;
import com.srt.CRMBackend.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskCategoryRepository taskCategoryRepository;

    @Override
    public void addTask(AddTaskRequest request) {
        TaskCategory taskCategory = taskCategoryRepository
                .findById(request.getTaskCategoryId())
                .orElseThrow(() -> new CrmBadRequestException("некорректный идентификатор категории задачи"));

        Task task = Task.builder()
                .name(request.getName())
                .description(request.getDescription())
                .numberOfPoints(request.getNumberOfPoints())
                .deadline(request.getDeadline())
                .publicationTime(LocalDateTime.now())
                .status(TaskStatus.FREE)
                .taskCategory(taskCategory)
                .build();
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(UUID taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public void addTaskCategory(TaskCategoryRequest request) {
        if (taskCategoryRepository.existsByName(request.getName())) {
            throw new CrmBadRequestException("некорректное имя категории");
        }

        TaskCategory taskCategory = TaskCategory.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();

        taskCategoryRepository.save(taskCategory);
    }

    @Override
    public List<TaskCategoryResponse> getAllTaskCategories() {
        return taskCategoryRepository.findAll().stream()
                .map(c -> TaskCategoryResponse.builder()
                        .id(c.getId())
                        .name(c.getName())
                        .description(c.getDescription()).build()
                ).toList();
    }
}
