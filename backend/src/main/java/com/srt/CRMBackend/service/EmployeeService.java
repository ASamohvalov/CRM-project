package com.srt.CRMBackend.service;

import com.srt.CRMBackend.DTO.employee.EmployeeDTO;
import com.srt.CRMBackend.auth.UserDetailsImpl;
import com.srt.CRMBackend.models.Employee;
import com.srt.CRMBackend.models.Role;
import com.srt.CRMBackend.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeDTO employeeData() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        Employee employee = employeeRepository.findByLoginWithRolesAndJobTitle(userDetails.getUsername())
                .orElseThrow();
        return EmployeeDTO.builder()
                .login(employee.getLogin())
                .email(employee.getEmail())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .jobTitleName(employee.getJobTitle().getName())
                .rolesName(
                        employee.getRoles().stream()
                                .map(Role::getAuthority)
                                .collect(Collectors.toSet())
                )
                .build();
    }
}
