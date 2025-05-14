package com.srt.CRMBackend.services.impl;

import com.srt.CRMBackend.DTO.task.AddTaskRequest;
import com.srt.CRMBackend.exceptions.CrmBadRequestException;
import com.srt.CRMBackend.models.tasks.Task;
import com.srt.CRMBackend.models.tasks.TaskCategory;
import com.srt.CRMBackend.models.tasks.TaskStatus;
import com.srt.CRMBackend.repositories.TaskRepository;
import com.srt.CRMBackend.repositories.tasks.TaskCategoryRepository;
import com.srt.CRMBackend.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

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
                .deadlineFrom(request.getDeadlineFrom())
                .deadlineTo(request.getDeadlineTo())
                .publicationTime(new Date())
                .status(TaskStatus.FREE)
                .taskCategory(taskCategory)
                .build();
        taskRepository.save(task);
    }


}
