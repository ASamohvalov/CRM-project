package com.srt.CRMBackend.services.auth;

import com.srt.CRMBackend.DTO.auth.JwtDTO;
import com.srt.CRMBackend.DTO.auth.SignInRequest;

public interface AuthenticationService {
    JwtDTO signIn(SignInRequest request);
    JwtDTO updateTokens(String refreshToken);
}
