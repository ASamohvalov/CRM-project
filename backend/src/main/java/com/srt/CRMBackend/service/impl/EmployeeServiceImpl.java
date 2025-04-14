package com.srt.CRMBackend.service.impl;

import com.srt.CRMBackend.DTO.employee.EmployeeDTO;
import com.srt.CRMBackend.auth.UserDetailsImpl;
import com.srt.CRMBackend.models.Employee;
import com.srt.CRMBackend.models.Role;
import com.srt.CRMBackend.repositories.EmployeeRepository;
import com.srt.CRMBackend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO getEmployeeData() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        // null pointer exception
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
