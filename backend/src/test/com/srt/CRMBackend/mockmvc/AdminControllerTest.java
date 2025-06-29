package com.srt.CRMBackend.mockmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.srt.CRMBackend.DTO.admin.JobTitleRequest;
import com.srt.CRMBackend.DTO.admin.AddQualificationRequest;
import com.srt.CRMBackend.mockmvc.utils.DefaultAdminAuthentication;
import com.srt.CRMBackend.mockmvc.utils.TestDataFactory;
import com.srt.CRMBackend.models.employees.JobTitle;
import com.srt.CRMBackend.models.employees.Qualification;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
@RequiredArgsConstructor
class AdminControllerTest {
    private final WebApplicationContext webApplicationContext;
    private final DefaultAdminAuthentication defaultAdminAuthentication;
    private final TestDataFactory testDataFactory;
    private final ObjectMapper objectMapper;

    private MockMvc mockMvc;
    private JobTitle untitledJobTitle;
    private Qualification untitledQualification;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        untitledJobTitle = testDataFactory.saveJobTitle(JobTitle.builder()
                .name("untitled")
                .description("untitled").build());
        untitledQualification = testDataFactory.saveQualification(Qualification.builder()
                .jobTitle(untitledJobTitle)
                .name("untitled").build());
    }

    @Test
    void addQualificationTest() throws Exception {
        AddQualificationRequest request = AddQualificationRequest.builder()
                .qualificationName("untitled1")
                .jobTitleId(untitledJobTitle.getId()).build();
        String token = defaultAdminAuthentication.getAccessToken(mockMvc);

        mockMvc.perform(post("/admin/add_employee")
                        .header("authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void addJobTitleTest() throws Exception {
        JobTitleRequest request = JobTitleRequest.builder()
                .name("untitled1")
                .description("untitled1").build();
        String token = defaultAdminAuthentication.getAccessToken(mockMvc);

        mockMvc.perform(post("/admin/add_job_title")
                        .header("authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
}
