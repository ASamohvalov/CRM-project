package com.srt.CRMBackend.DTO.admin;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddJobTitleRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
