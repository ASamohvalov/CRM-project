package com.srt.CRMBackend.services.impl;

import com.srt.CRMBackend.DTO.admin.QualificationResponse;
import com.srt.CRMBackend.DTO.employee.EmployeeDTO;
import com.srt.CRMBackend.DTO.employee.JobTitleDto;
import com.srt.CRMBackend.models.employees.Role;
import com.srt.CRMBackend.repositories.employee.EmployeeRepository;
import com.srt.CRMBackend.repositories.employee.JobTitleRepository;
import com.srt.CRMBackend.repositories.employee.QualificationRepository;
import com.srt.CRMBackend.services.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final QualificationRepository qualificationRepository;
    private final JobTitleRepository jobTitleRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public List<QualificationResponse> getAllQualifications() {
        return qualificationRepository.findAllWithJobTitle().stream()
                .map(q -> QualificationResponse.builder()
                        .id(q.getId())
                        .name(q.getName())
                        .jobTitle(JobTitleDto.builder()
                                .id(q.getJobTitle().getId())
                                .name(q.getJobTitle().getName())
                                .description(q.getJobTitle().getDescription()).build()
                        ).build()
                ).toList();
    }

    @Override
    public List<JobTitleDto> getAllJobTitles() {
        return jobTitleRepository.findAll().stream()
                .map((jt) -> JobTitleDto.builder()
                        .id(jt.getId())
                        .name(jt.getName())
                        .description(jt.getDescription()).build())
                .toList();
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAllWithRolesAndQualificationAndJobTitle().stream()
                .map(e -> EmployeeDTO.builder()
                        .login(e.getLogin())
                        .email(e.getEmail())
                        .firstName(e.getFullName().getFirstName())
                        .lastName(e.getFullName().getLastName())
                        .patronymic(e.getFullName().getPatronymic())
                        .qualificationName(e.getQualification().getName())
                        .jobTitleName(e.getQualification().getJobTitle().getName())
                        .rolesName(
                                e.getRoles().stream()
                                        .map(Role::getAuthority)
                                        .collect(Collectors.toSet())
                        ).build()
                ).toList();
    }
}
