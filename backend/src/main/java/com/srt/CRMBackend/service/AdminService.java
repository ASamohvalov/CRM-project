package com.srt.CRMBackend.service;

import com.srt.CRMBackend.DTO.admin.AddEmployeeRequest;
import com.srt.CRMBackend.DTO.admin.AddJobTitleRequest;

import java.util.Map;
import java.util.UUID;

public interface AdminService {
    void addEmployee(AddEmployeeRequest request);
    void addJobTitle(AddJobTitleRequest request);
    Map<UUID, String> getAllJobTitles();
}
