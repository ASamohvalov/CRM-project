package com.srt.CRMBackend.controllers.privilege;

import com.srt.CRMBackend.DTO.admin.AddEmployeeRequest;
import com.srt.CRMBackend.DTO.admin.AddJobTitleRequest;
import com.srt.CRMBackend.DTO.admin.AddQualificationRequest;
import com.srt.CRMBackend.services.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    // todo регистрация админов, менеджеров

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
}
