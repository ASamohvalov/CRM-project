package com.srt.CRMBackend.repositories.tasks;

import com.srt.CRMBackend.models.tasks.Task;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    @Query("""
        SELECT t FROM Task t
        JOIN TaskCategory tc ON t.taskCategory.id = tc.id
    """)
    List<Task> findAllWithCategory();
}
