package com.srt.CRMBackend.controllers;

import com.srt.CRMBackend.DTO.admin.AddEmployeeRequest;
import com.srt.CRMBackend.DTO.admin.AddJobTitleRequest;
import com.srt.CRMBackend.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/add_employee")
    public void addEmployee(@Valid @RequestBody AddEmployeeRequest request) {
        System.out.println("hello");
        adminService.addEmployee(request);
    }

    @PostMapping("/add_job_title")
    public void addJobTitle(@Valid @RequestBody AddJobTitleRequest request) {
        adminService.addJobTitle(request);
    }
}
