package com.srt.CRMBackend.controllers;

import com.srt.CRMBackend.DTO.auth.JwtDTO;
import com.srt.CRMBackend.DTO.auth.SignInRequest;
import com.srt.CRMBackend.service.auth.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "аутентификация", description = "все методы доступны неавторизованным пользователям")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/sign_in")
    public JwtDTO signIn(@Valid @RequestBody SignInRequest request) {
        return authenticationService.signIn(request);
    }

    @PostMapping("/update_tokens")
    public JwtDTO updateTokens(@RequestParam String refreshToken) {
        return authenticationService.updateTokens(refreshToken);
    }
}
