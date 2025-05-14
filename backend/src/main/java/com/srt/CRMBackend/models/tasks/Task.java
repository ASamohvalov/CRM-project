package com.srt.CRMBackend.models.tasks;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int numberOfPoints;

    @Temporal(TemporalType.DATE)
    private Date deadlineFrom;

    @Temporal(TemporalType.DATE)
    private Date deadlineTo;

    @Temporal(TemporalType.DATE)
    private Date publicationTime;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "task_category_id")
    private TaskCategory taskCategory;
}
