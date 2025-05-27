package com.srt.CRMBackend.services;

import com.srt.CRMBackend.DTO.admin.AddEmployeeRequest;
import com.srt.CRMBackend.DTO.admin.AddJobTitleRequest;
import com.srt.CRMBackend.DTO.admin.AddQualificationRequest;
import com.srt.CRMBackend.DTO.admin.QualificationResponse;
import com.srt.CRMBackend.DTO.employee.JobTitleDto;

import java.util.List;

public interface AdminService {
    void addEmployee(AddEmployeeRequest request);
    void addJobTitle(AddJobTitleRequest request);
    void addQualification(AddQualificationRequest request);
}
