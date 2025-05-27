package com.srt.CRMBackend.services;

import com.srt.CRMBackend.DTO.admin.QualificationResponse;
import com.srt.CRMBackend.DTO.employee.EmployeeDTO;
import com.srt.CRMBackend.DTO.employee.JobTitleDto;

import java.util.List;

public interface ManagerService {
    List<QualificationResponse> getAllQualifications();
    List<JobTitleDto> getAllJobTitles();
    List<EmployeeDTO> getAllEmployees();
}
