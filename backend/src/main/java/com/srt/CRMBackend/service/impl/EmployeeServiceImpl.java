package com.srt.CRMBackend.service.impl;

import com.srt.CRMBackend.DTO.employee.EmployeeDTO;
import com.srt.CRMBackend.auth.UserDetailsImpl;
import com.srt.CRMBackend.models.employees.Employee;
import com.srt.CRMBackend.models.employees.JobTitle;
import com.srt.CRMBackend.models.employees.Qualification;
import com.srt.CRMBackend.models.employees.Role;
import com.srt.CRMBackend.repositories.EmployeeRepository;
import com.srt.CRMBackend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO getEmployeeData() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        Employee employee = employeeRepository.findByLoginWithRolesAndQualificationAndJobTitle(userDetails.getUsername())
                .orElseThrow();

        Optional<Qualification> qualification = Optional.ofNullable(employee.getQualification());

        return EmployeeDTO.builder()
                .login(employee.getLogin())
                .email(employee.getEmail())
                .firstName(employee.getFullName().getFirstName())
                .lastName(employee.getFullName().getLastName())
                .patronymic(employee.getFullName().getPatronymic())
                .qualificationName(
                        qualification.map(Qualification::getName)
                                .orElse("unknown")
                )
                .jobTitleName(
                        qualification.map(Qualification::getJobTitle)
                                .map(JobTitle::getName)
                                .orElse("unknown")
                )
                .rolesName(
                        employee.getRoles().stream()
                                .map(Role::getAuthority)
                                .collect(Collectors.toSet())
                )
                .build();
    }
}
