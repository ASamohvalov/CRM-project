package com.srt.CRMBackend.service.auth;

import com.srt.CRMBackend.DTO.auth.JwtRequest;
import com.srt.CRMBackend.DTO.auth.SignInRequest;

public interface AuthenticationService {

    JwtRequest signIn(SignInRequest request);
}
