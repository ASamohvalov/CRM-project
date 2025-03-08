package com.srt.CRMBackend.service;

import com.srt.CRMBackend.DTO.admin.AddEmployeeRequest;
import com.srt.CRMBackend.DTO.admin.AddJobTitleRequest;
import com.srt.CRMBackend.exceptions.ValidationException;
import com.srt.CRMBackend.models.Employee;
import com.srt.CRMBackend.models.JobTitle;
import com.srt.CRMBackend.repositories.EmployeeRepository;
import com.srt.CRMBackend.repositories.JobTitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final EmployeeRepository employeeRepository;
    private final JobTitleRepository jobTitleRepository;
    private final PasswordEncoder passwordEncoder;

    public void addEmployee(AddEmployeeRequest request) {
        validateAddEmployee(request);

        JobTitle jobTitle = jobTitleRepository.findById(request.getJobTitle())
                .orElseThrow(() -> new ValidationException(
                        Map.of("jobTitle", "передан некорректный идентификатор")
                ));

        Employee employee = Employee.builder()
                .login(request.getLogin())
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .jobTitle(jobTitle)
                .build();

        employeeRepository.save(employee);
    }

    public void addJobTitle(AddJobTitleRequest request) {
        if (jobTitleRepository.existsByName(request.getName())) {
            throw new ValidationException(
                    Map.of("name", "такая должность уже существует")
            );
        }

        JobTitle jobTitle = JobTitle.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
        jobTitleRepository.save(jobTitle);
    }

    private void validateAddEmployee(AddEmployeeRequest request) {
        Map<String, String> errors = new HashMap<>();
        if (employeeRepository.existsByLogin(request.getLogin())) {
            errors.put("login", "этот логин уже занят");
        }
        if (employeeRepository.existsByEmail(request.getEmail())) {
            errors.put("email", "эта почта уже используется");
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
