package com.srt.CRMBackend.DTO.admin;

import com.srt.CRMBackend.DTO.employee.JobTitleDto;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class QualificationResponse {
    private UUID id;
    private JobTitleDto jobTitle;
    private String name;
}
