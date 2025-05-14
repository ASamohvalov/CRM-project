package com.srt.CRMBackend.DTO.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SignInRequest {
    @NotBlank(message = "поле не должно быть пустым")
    private String login;
    @NotBlank(message = "поле не должно быть пустым")
    private String password;
}
