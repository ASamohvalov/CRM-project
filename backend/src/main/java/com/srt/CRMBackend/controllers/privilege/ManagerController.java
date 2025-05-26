package com.srt.CRMBackend.controllers.privilege;

import com.srt.CRMBackend.DTO.admin.QualificationResponse;
import com.srt.CRMBackend.DTO.employee.JobTitleDto;
import com.srt.CRMBackend.services.ManagerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
@Tag(name = "менеджеры", description = "все методы доступны менеджерам и админам")
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping("/get_all_job_titles")
    public List<JobTitleDto> getAllJobTitles() {
        return managerService.getAllJobTitles();
    }

    @GetMapping("/get_all_qualifications")
    public List<QualificationResponse> getAllQualifications() {
        return managerService.getAllQualifications();
    }

//    @GetMapping("/get_all_employees")
//    public List<EmployeeDTO> getAllEmployees() {
//        return managerService.getAllEmployees();
//    }
}
