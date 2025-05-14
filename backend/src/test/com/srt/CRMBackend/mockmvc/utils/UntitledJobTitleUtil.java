package com.srt.CRMBackend.mockmvc.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.srt.CRMBackend.DTO.admin.AddJobTitleRequest;
import com.srt.CRMBackend.models.employees.JobTitle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@Component
@RequiredArgsConstructor
public class UntitledJobTitleUtil {
    private final ObjectMapper objectMapper;
    private final DefaultAdminAuthentication defaultAdminAuthentication;

    private static JobTitle jobTitle;

    public JobTitle getJobTitle(MockMvc mockMvc) throws Exception {
        if (jobTitle == null) {
            AddJobTitleRequest request = AddJobTitleRequest.builder()
                    .name("untitled")
                    .description("untitled").build();
            String token = defaultAdminAuthentication.getAccessToken(mockMvc);

            mockMvc.perform(post("/admin/add_job_title")
                            .header("authorization", "Bearer " + token)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)));


        }
        return jobTitle;
    }
}
