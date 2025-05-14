package com.srt.CRMBackend.init;

import com.srt.CRMBackend.models.employees.Employee;
import com.srt.CRMBackend.models.employees.FullName;
import com.srt.CRMBackend.repositories.EmployeeRepository;
import com.srt.CRMBackend.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DefaultAdminInitialization {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Value("${admin.login}")
    private String login;

    @Value("${admin.email}")
    private String email;

    @Value("${admin.password}")
    private String password;

    public void init() {
        if (!employeeRepository.existsByLogin(login)) {
            Employee admin = Employee.builder()
                    .login(login)
                    .password(passwordEncoder.encode(password))
                    .email(email)
                    .roles(Set.of(roleRepository.getByName("ROLE_ADMIN")))
                    .fullName(FullName.builder()
                            .firstName("admin")
                            .lastName("admin")
                            .patronymic("admin")
                            .build())
                    .build();

            employeeRepository.save(admin);
        }
    }
}
