package com.srt.CRMBackend.services.employee;

import com.srt.CRMBackend.DTO.employee.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO getEmployeeData();
    List<EmployeeDTO> getAllEmployees();
}
