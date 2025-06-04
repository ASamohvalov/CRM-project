package com.srt.CRMBackend.repositories.tasks;

import com.srt.CRMBackend.models.tasks.EmployeeTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeTaskRepository extends JpaRepository<EmployeeTask, UUID> {
}
