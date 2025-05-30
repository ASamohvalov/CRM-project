package com.srt.CRMBackend.DTO.admin;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AddQualificationRequest {
    @NotNull
    private UUID jobTitleId;
    @NotBlank
    private String qualificationName;
}
