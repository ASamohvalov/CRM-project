package com.srt.CRMBackend.DTO.admin;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AddEmployeeRequest {
    @NotBlank
    private String login;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    @NotNull
    private UUID jobTitle;
}
