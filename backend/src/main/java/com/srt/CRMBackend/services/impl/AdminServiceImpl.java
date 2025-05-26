package com.srt.CRMBackend.services.impl;

import com.srt.CRMBackend.DTO.admin.AddEmployeeRequest;
import com.srt.CRMBackend.DTO.admin.AddJobTitleRequest;
import com.srt.CRMBackend.DTO.admin.AddQualificationRequest;
import com.srt.CRMBackend.exceptions.admin.ValidationException;
import com.srt.CRMBackend.exceptions.admin.ValidationOneFieldException;
import com.srt.CRMBackend.models.employees.*;
import com.srt.CRMBackend.repositories.employee.*;
import com.srt.CRMBackend.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final QualificationRepository qualificationRepository;
    private final JobTitleRepository jobTitleRepository;
    private final PersonalEmployeeDataRepository personalEmployeeDataRepository;

    @Override
    public void addEmployee(AddEmployeeRequest request) {
        validateAddEmployee(request);

        Qualification qualification = qualificationRepository
                .findById(request.getQualificationId())
                .orElseThrow(() -> new ValidationException(
                        Map.of("qualification", "неверный идентификатор квалификации"))
                );

        FullName fullName = FullName.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .patronymic(request.getPatronymic()).build();

        Employee employee = Employee.builder()
                .login(request.getLogin())
                .email(request.getEmail())
                .fullName(fullName)
                .password(passwordEncoder.encode(request.getPassword()))
                .qualification(qualification)
                .roles(Set.of(roleRepository.getByName("ROLE_EMPLOYEE"))).build();
        employeeRepository.save(employee);

        PersonalEmployeeData employeeData = PersonalEmployeeData.builder()
                .employee(employee)
                .passportNumber(request.getPassportNumber())
                .passportSeries(request.getPassportSeries())
                .dateOfEmployment(LocalDate.now()).build();
        personalEmployeeDataRepository.save(employeeData);
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
    public void addQualification(AddQualificationRequest request) {
        JobTitle jobTitle = jobTitleRepository.findById(request.getJobTitleId())
                .orElseThrow(() -> new ValidationOneFieldException("передан неверный идентификатор"));

        Qualification qualification = Qualification.builder()
                .name(request.getQualificationName())
                .jobTitle(jobTitle).build();
        qualificationRepository.save(qualification);
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
