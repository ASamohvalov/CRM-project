package com.srt.CRMBackend.repositories.tasks;

import com.srt.CRMBackend.models.tasks.EmployeeTask;
import com.srt.CRMBackend.models.tasks.ExecutionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeTaskRepository extends JpaRepository<EmployeeTask, UUID> {
    @Query("""
                SELECT et FROM EmployeeTask et
                JOIN FETCH et.task
                WHERE et.employee.id = :employeeId
            """)
    List<EmployeeTask> findAllTasksByEmployeeId(UUID employeeId);

    @Query("""
                SELECT et FROM EmployeeTask et
                WHERE et.executionStatus = :status
            """)
    List<EmployeeTask> findByExecutionStatus(ExecutionStatus status);
}
