package com.srt.CRMBackend.DTO.admin;

import com.srt.CRMBackend.DTO.employee.JobTitleDTO;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class QualificationResponse {
    private UUID id;
    private JobTitleDTO jobTitle;
    private String name;
}
