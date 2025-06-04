package com.srt.CRMBackend.services.impl;

import com.srt.CRMBackend.DTO.admin.QualificationResponse;
import com.srt.CRMBackend.DTO.employee.EmployeeDTO;
import com.srt.CRMBackend.DTO.employee.JobTitleDTO;
import com.srt.CRMBackend.repositories.employee.JobTitleRepository;
import com.srt.CRMBackend.repositories.employee.QualificationRepository;
import com.srt.CRMBackend.services.employee.EmployeeService;
import com.srt.CRMBackend.services.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final QualificationRepository qualificationRepository;
    private final JobTitleRepository jobTitleRepository;
    private final EmployeeService employeeService;

    @Override
    public List<QualificationResponse> getAllQualifications() {
        return qualificationRepository.findAllWithJobTitle().stream()
                .map(q -> QualificationResponse.builder()
                        .id(q.getId())
                        .name(q.getName())
                        .jobTitle(JobTitleDTO.builder()
                                .id(q.getJobTitle().getId())
                                .name(q.getJobTitle().getName())
                                .description(q.getJobTitle().getDescription()).build()
                        ).build()
                ).toList();
    }

    @Override
    public List<JobTitleDTO> getAllJobTitles() {
        return jobTitleRepository.findAll().stream()
                .map((jt) -> JobTitleDTO.builder()
                        .id(jt.getId())
                        .name(jt.getName())
                        .description(jt.getDescription()).build())
                .toList();
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
