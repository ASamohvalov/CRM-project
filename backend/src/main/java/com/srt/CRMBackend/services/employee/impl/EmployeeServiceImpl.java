package com.srt.CRMBackend.services.employee.impl;

import com.srt.CRMBackend.DTO.employee.EmployeeDTO;
import com.srt.CRMBackend.auth.UserDetailsImpl;
import com.srt.CRMBackend.models.employees.Employee;
import com.srt.CRMBackend.models.employees.JobTitle;
import com.srt.CRMBackend.models.employees.Qualification;
import com.srt.CRMBackend.models.employees.Role;
import com.srt.CRMBackend.repositories.employee.EmployeeRepository;
import com.srt.CRMBackend.services.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
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

        return toEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAllWithRolesAndQualificationAndJobTitle();
        return employees.stream().map(this::toEmployeeDTO)
                .toList();
    }

    public EmployeeDTO toEmployeeDTO(Employee employee) {
        Optional<Qualification> qualification = Optional.ofNullable(employee.getQualification());
        return EmployeeDTO.builder()
                .id(employee.getId())
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
