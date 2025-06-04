package com.srt.CRMBackend.mappers;

import com.srt.CRMBackend.DTO.task.TaskCategoryDTO;
import com.srt.CRMBackend.DTO.task.TaskResponse;
import com.srt.CRMBackend.models.tasks.Task;
import com.srt.CRMBackend.models.tasks.TaskCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Named("toTaskCategoryDTO")
    TaskCategoryDTO toTaskCategoryDTO(TaskCategory taskCategory);

    @Mapping(target = "category", source = "taskCategory", qualifiedByName = "toTaskCategoryDTO")
    TaskResponse toTaskResponse(Task task);
}
