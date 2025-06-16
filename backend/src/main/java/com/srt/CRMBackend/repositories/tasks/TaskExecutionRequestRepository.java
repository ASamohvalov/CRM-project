package com.srt.CRMBackend.repositories.tasks;

import com.srt.CRMBackend.models.tasks.TaskExecutionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface TaskExecutionRequestRepository extends JpaRepository<TaskExecutionRequest, UUID> {
    @Query("""
        SELECT ter FROM TaskExecutionRequest ter
        JOIN FETCH ter.task
        JOIN FETCH ter.task.taskCategory
        JOIN FETCH ter.employee
        JOIN FETCH ter.employee.roles
        JOIN FETCH ter.employee.fullName
        JOIN FETCH ter.employee.qualification
        JOIN FETCH ter.employee.qualification.jobTitle
        WHERE ter.isAccepted = false
    """)
    List<TaskExecutionRequest> findAllUnacceptedWithEmployeeAndTask();

    @Query("""
        SELECT ter FROM TaskExecutionRequest ter
        JOIN FETCH ter.task
        JOIN FETCH ter.task.taskCategory
        WHERE ter.employee.id = :employeeId
    """)
    List<TaskExecutionRequest> findAllByEmployeeIdWithTask(UUID employeeId);
}
