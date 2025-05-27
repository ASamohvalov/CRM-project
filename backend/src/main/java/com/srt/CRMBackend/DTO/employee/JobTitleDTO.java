package com.srt.CRMBackend.DTO.employee;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class JobTitleDto {
    private UUID id;
    private String name;
    private String description;
}
