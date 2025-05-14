package com.srt.CRMBackend.mockmvc.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.srt.CRMBackend.DTO.auth.JwtDTO;
import com.srt.CRMBackend.DTO.auth.SignInRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Component
@RequiredArgsConstructor
public class AuthenticationUtil {
    private final ObjectMapper objectMapper;

    public JwtDTO authenticate(MockMvc mockMvc, SignInRequest request) throws Exception {
        MvcResult result = mockMvc.perform(post("/auth/sign_in")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();
        return objectMapper.readValue(json, JwtDTO.class);
    }
}
