package com.srt.CRMBackend.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignUpRequest {
    @NotBlank(message = "логин не может быть пустым")
    @Size(min = 3, max = 30, message = "логин должен быть в пределах от 3 до 30 символов")
    private String login;

    @Email(message = "адрес электронной почты недействителен")
    private String email;

    @NotBlank(message = "пароль не может быть пустым")
    @Size(min = 8, message = "пароль должен содержать не менее 8 символов")
    private String password;

    @NotBlank(message = "имя не может быть пустым")
    private String firstName;

    @NotBlank(message = "фамилия не может быть пустой")
    private String lastName;
}
