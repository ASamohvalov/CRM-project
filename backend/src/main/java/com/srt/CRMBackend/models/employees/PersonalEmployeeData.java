package com.srt.CRMBackend.models.employees;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "personal_employees_data")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PersonalEmployeeData {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String phoneNumber;

    private int passportNumber;
    private int passportSeries;

    private LocalDate dateOfEmployment;
}
