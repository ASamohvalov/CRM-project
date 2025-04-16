package com.srt.CRMBackend.models.employees;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "job_titles")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;
}
