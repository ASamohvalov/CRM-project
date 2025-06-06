package com.srt.CRMBackend.services;

import com.srt.CRMBackend.DTO.admin.AddEmployeeRequest;
import com.srt.CRMBackend.DTO.admin.JobTitleRequest;
import com.srt.CRMBackend.DTO.admin.AddQualificationRequest;

import java.util.UUID;

public interface AdminService {
    void addEmployee(AddEmployeeRequest request);
    void addJobTitle(JobTitleRequest request);
    void addQualification(AddQualificationRequest request);

    void deleteJobTitle(UUID id);
    void deleteQualification(UUID id);
}
