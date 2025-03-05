package com.srt.CRMBackend.DTO.admin;

import lombok.Data;

import java.util.UUID;

@Data
public class AddEmployeeRequest {
    private String login;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private UUID jobTitle;
}
