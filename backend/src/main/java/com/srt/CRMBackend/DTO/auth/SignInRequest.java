package com.srt.CRMBackend.DTO.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignInRequest {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
