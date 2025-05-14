package com.srt.CRMBackend.mockmvc.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.srt.CRMBackend.DTO.auth.JwtDTO;
import com.srt.CRMBackend.DTO.auth.SignInRequest;
import lombok.Getter;
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
    @Getter
    private String login;

    @Value("${admin.password}")
    @Getter
    private String password;

    private final AuthenticationUtil authenticationUtil;

    public String getAccessToken(MockMvc mockMvc) throws Exception {
        if (accessToken == null) {
            authenticate(mockMvc);
        }
        return accessToken;
    }

    public String getRefreshToken(MockMvc mockMvc) throws Exception {
        if (refreshToken == null) {
            authenticate(mockMvc);
        }
        return refreshToken;
    }

    public void authenticate(MockMvc mockMvc) throws Exception {
        SignInRequest request = new SignInRequest(login, password);
        JwtDTO jwtDTO = authenticationUtil.authenticate(mockMvc, request);

        accessToken = jwtDTO.getAccessToken();
        refreshToken = jwtDTO.getRefreshToken();
    }
}
