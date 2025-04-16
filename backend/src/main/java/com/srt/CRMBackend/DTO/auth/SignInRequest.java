package com.srt.CRMBackend.DTO.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignInRequest {
    @NotBlank(message = "поле не должно быть пустым")
    private String login;
    @NotBlank(message = "поле не должно быть пустым")
    private String password;
}
