package com.srt.CRMBackend.controllers;

import com.srt.CRMBackend.DTO.SignUpRequest;
import com.srt.CRMBackend.exceptions.LoginAlreadyExistsException;
import com.srt.CRMBackend.services.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sign_up")
public class SignUpController {
    private final SignUpService signUpService;

    @PostMapping
    public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequest request) {
        try {
            signUpService.signUp(request);
            return ResponseEntity.ok("сотрудник успешно зарегистрирован");
        } catch (LoginAlreadyExistsException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }
}
