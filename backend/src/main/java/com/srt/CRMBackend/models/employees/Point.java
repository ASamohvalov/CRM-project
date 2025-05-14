package com.srt.CRMBackend.models.employees;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "points")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int total;

    @Temporal(TemporalType.DATE)
    private Date lastUpdate;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
