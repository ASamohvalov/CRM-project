package com.srt.CRMBackend.service.impl;

import com.srt.CRMBackend.DTO.admin.AddEmployeeRequest;
import com.srt.CRMBackend.DTO.admin.AddJobTitleRequest;
import com.srt.CRMBackend.exceptions.ValidationException;
import com.srt.CRMBackend.models.Employee;
import com.srt.CRMBackend.models.JobTitle;
import com.srt.CRMBackend.repositories.EmployeeRepository;
import com.srt.CRMBackend.repositories.JobTitleRepository;
import com.srt.CRMBackend.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final EmployeeRepository employeeRepository;
    private final JobTitleRepository jobTitleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
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
                .patronymic(request.getPatronymic())
                .password(passwordEncoder.encode(request.getPassword()))
                .jobTitle(jobTitle)
                // todo roles
                .build();

        employeeRepository.save(employee);
    }

    @Override
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

    @Override
    public Map<UUID, String> getAllJobTitles() {
        return jobTitleRepository.findAll().stream()
                .collect(Collectors.toMap(
                        JobTitle::getId,
                        JobTitle::getName
                ));
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
