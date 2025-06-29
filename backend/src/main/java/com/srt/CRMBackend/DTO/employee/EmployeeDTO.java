package com.srt.CRMBackend.DTO.employee;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class EmployeeDTO {
    private UUID id;
    private String login;
    private String email;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String jobTitleName;
    private String qualificationName;
    private Set<String> rolesName;
}
