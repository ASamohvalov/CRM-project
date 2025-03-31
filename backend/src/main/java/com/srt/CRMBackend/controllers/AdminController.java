package com.srt.CRMBackend.controllers;

import com.srt.CRMBackend.DTO.admin.AddEmployeeRequest;
import com.srt.CRMBackend.DTO.admin.AddJobTitleRequest;
import com.srt.CRMBackend.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/add_employee")
    public Map<String, String> addEmployee(@Valid @RequestBody AddEmployeeRequest request) {
        adminService.addEmployee(request);
        return Map.of("message", "работник успешно добавлен");
    }

    @PostMapping("/add_job_title")
    public Map<String, String> addJobTitle(@Valid @RequestBody AddJobTitleRequest request) {
        adminService.addJobTitle(request);
        return Map.of("message", "должность успешно добавлена");
    }
}
