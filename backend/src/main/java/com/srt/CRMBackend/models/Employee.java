package com.srt.CRMBackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "employees")
@Getter
@Setter
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

    @ManyToOne
    private JobTitle jobTitle;
}
