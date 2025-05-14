package com.srt.CRMBackend.repositories.tasks;

import com.srt.CRMBackend.models.tasks.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskCategoryRepository extends JpaRepository<TaskCategory, UUID> {
}
