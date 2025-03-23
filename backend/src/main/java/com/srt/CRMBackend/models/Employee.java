package com.srt.CRMBackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "employees")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String login;

    @Column(unique = true)
    private String email;

    private String password;
    private String firstName;
    private String lastName;
    private String patronymic;

    @ManyToOne
    private JobTitle jobTitle;

    @OneToMany
    @JoinColumn(name = "employee_role_id")
    private Set<EmployeeRole> roles = new HashSet<>();
}
