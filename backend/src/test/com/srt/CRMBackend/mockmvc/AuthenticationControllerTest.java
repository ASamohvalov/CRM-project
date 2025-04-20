package com.srt.CRMBackend.mockmvc;

import com.srt.CRMBackend.mockmvc.utils.DefaultAdminAuthentication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthenticationControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private DefaultAdminAuthentication defaultAdminAuthentication;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void signInTest() throws Exception {
        defaultAdminAuthentication.authenticate();
    }

    @Test
    void updateTokensTest() throws Exception {
        String refreshTokenJson = String.format("""
                {
                    "refreshToken": "%s"
                }
                """, defaultAdminAuthentication.getRefreshToken());

        System.out.println(refreshTokenJson);

        mockMvc.perform(post("/auth/update_tokens")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(refreshTokenJson))
                .andExpect(status().isOk());
    }
}
