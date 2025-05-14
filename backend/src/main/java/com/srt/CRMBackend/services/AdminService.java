package com.srt.CRMBackend.services;

import com.srt.CRMBackend.DTO.admin.AddEmployeeRequest;
import com.srt.CRMBackend.DTO.admin.AddJobTitleRequest;
import com.srt.CRMBackend.DTO.admin.AddQualificationRequest;

import java.util.Map;
import java.util.UUID;

public interface AdminService {
    void addEmployee(AddEmployeeRequest request);
    void addJobTitle(AddJobTitleRequest request);
    void addQualification(AddQualificationRequest request);
    Map<UUID, String> getAllJobTitles();
}
