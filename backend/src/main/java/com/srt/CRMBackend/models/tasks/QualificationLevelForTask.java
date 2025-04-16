package com.srt.CRMBackend.models.tasks;

import com.srt.CRMBackend.models.employees.Qualification;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "qualification_level_for_task")
public class QualificationLevelForTask {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "qualification_id")
    private Qualification qualification;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
