package com.srt.CRMBackend.mockmvc.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.srt.CRMBackend.DTO.auth.JwtDTO;
import com.srt.CRMBackend.DTO.auth.SignInRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;

@Component
@RequiredArgsConstructor
public class DefaultAdminAuthentication {
    private static String accessToken;
    private static String refreshToken;

    @Value("${admin.login}")
    private String login;
    @Value("${admin.password}")
    private String password;

    private final ObjectMapper objectMapper;
    private final MockMvc mockMvc;
    private final AuthenticationUtil authenticationUtil;

    public String getAccessToken() throws Exception {
        if (accessToken == null) {
            authenticate();
        }
        return accessToken;
    }

    public String getRefreshToken() throws Exception {
        if (refreshToken == null) {
            authenticate();
        }
        return refreshToken;
    }

    public void authenticate() throws Exception {
        SignInRequest request = new SignInRequest(login, password);
        JwtDTO jwtDTO = authenticationUtil.authenticate(mockMvc, request);

        accessToken = jwtDTO.getAccessToken();
        refreshToken = jwtDTO.getRefreshToken();
    }
}
