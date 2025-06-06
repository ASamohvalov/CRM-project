package com.srt.CRMBackend.DTO.admin;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobTitleRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
