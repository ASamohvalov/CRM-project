package com.srt.CRMBackend.controllers;

import com.srt.CRMBackend.DTO.employee.EmployeeDTO;
import com.srt.CRMBackend.services.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@Tag(name = "сотрудники", description = "методы доступны всем авторизованным работникам")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/get_employee_data")
    public EmployeeDTO employeeData() {
        return employeeService.getEmployeeData();
    }

}
