package com.srt.CRMBackend.models;

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

    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
}
