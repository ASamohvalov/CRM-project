package com.srt.CRMBackend.DTO.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtDTO {
    private String accessToken;
    private String refreshToken;
}
