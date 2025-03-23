package com.srt.CRMBackend.DTO.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtRequest {
    private String accessToken;
    private String refreshToken;
}
