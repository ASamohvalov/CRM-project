package com.srt.CRMBackend.controllers;

import com.srt.CRMBackend.DTO.admin.AddEmployeeRequest;
import com.srt.CRMBackend.DTO.admin.AddJobTitleRequest;
import com.srt.CRMBackend.DTO.admin.AddQualificationRequest;
import com.srt.CRMBackend.services.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

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

    @PostMapping("/add_qualification")
    public Map<String, String> addQualification(@Valid @RequestBody AddQualificationRequest request) {
        adminService.addQualification(request);
        return Map.of("message", "квалификация успешно добавлена");
    }

    @GetMapping("/get_all_job_titles")
    public Map<UUID, String> getAllJobTitles() {
        return adminService.getAllJobTitles();
    }
}
