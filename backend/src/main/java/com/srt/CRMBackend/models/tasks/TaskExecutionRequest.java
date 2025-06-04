package com.srt.CRMBackend.models.tasks;

import com.srt.CRMBackend.models.employees.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "task_execution_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskExecutionRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    private boolean isAccepted = false;
}
