package com.srt.CRMBackend.services;

import com.srt.CRMBackend.DTO.admin.QualificationResponse;
import com.srt.CRMBackend.DTO.employee.EmployeeDTO;
import com.srt.CRMBackend.DTO.employee.JobTitleDTO;

import java.util.List;

public interface ManagerService {
    List<QualificationResponse> getAllQualifications();
    List<JobTitleDTO> getAllJobTitles();
    List<EmployeeDTO> getAllEmployees();
}
