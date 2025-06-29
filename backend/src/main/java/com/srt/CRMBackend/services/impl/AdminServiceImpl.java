package com.srt.CRMBackend.services.impl;

import com.srt.CRMBackend.DTO.admin.AddEmployeeRequest;
import com.srt.CRMBackend.DTO.admin.JobTitleRequest;
import com.srt.CRMBackend.DTO.admin.AddQualificationRequest;
import com.srt.CRMBackend.exceptions.admin.ValidationException;
import com.srt.CRMBackend.exceptions.admin.ValidationOneFieldException;
import com.srt.CRMBackend.models.employees.*;
import com.srt.CRMBackend.repositories.employee.*;
import com.srt.CRMBackend.services.AdminService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final QualificationRepository qualificationRepository;
    private final JobTitleRepository jobTitleRepository;
    private final PersonalEmployeeDataRepository personalEmployeeDataRepository;
    private final PointRepository pointRepository;

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
                .roles(Set.of(roleRepository.getByName(request.getRole()))).build();
        employeeRepository.save(employee);

        PersonalEmployeeData employeeData = PersonalEmployeeData.builder()
                .employee(employee)
                .passportNumber(request.getPassportNumber())
                .passportSeries(request.getPassportSeries())
                .dateOfEmployment(LocalDate.now()).build();
        personalEmployeeDataRepository.save(employeeData);
    }

    @Override
    public void addJobTitle(JobTitleRequest request) {
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

    @Override
    public void deleteJobTitle(UUID id) {
        if (qualificationRepository.existsByJobTitleId(id)) {
            throw new ValidationOneFieldException("для удаления должности необходимо удалить зависящие квалификации");
        }
        jobTitleRepository.deleteById(id);
    }

    @Override
    public void deleteQualification(UUID id) {
        if (employeeRepository.existsByQualificationId(id)) {
            throw new ValidationOneFieldException("для удаления квалификации необходимо изменить должности сотрудникам с такой квалификацией");
        }
        qualificationRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteEmployee(UUID id) {
        personalEmployeeDataRepository.deleteByEmployeeId(id);
        pointRepository.deleteByEmployeeId(id);
        employeeRepository.deleteById(id);
    }

    private void validateAddEmployee(AddEmployeeRequest request) {
        Map<String, String> errors = new HashMap<>();
        if (!List.of("ROLE_ADMIN", "ROLE_MANAGER", "ROLE_EMPLOYEE").contains(request.getRole())) {
            errors.put("role", "некорректная роль");
        }
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
