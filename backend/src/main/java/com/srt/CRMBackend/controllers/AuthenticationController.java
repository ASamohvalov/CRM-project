package com.srt.CRMBackend.controllers;

import com.srt.CRMBackend.DTO.auth.JwtRequest;
import com.srt.CRMBackend.DTO.auth.SignInRequest;
import com.srt.CRMBackend.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/sign_in")
    private JwtRequest signIn(@Valid @RequestBody SignInRequest request) {
        return authenticationService.signIn(request);
    }
}
