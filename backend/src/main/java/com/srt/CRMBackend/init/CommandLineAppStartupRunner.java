package com.srt.CRMBackend.init;

import com.srt.CRMBackend.models.Employee;
import com.srt.CRMBackend.models.Role;
import com.srt.CRMBackend.repositories.EmployeeRepository;
import com.srt.CRMBackend.repositories.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        initRoles();
        initDefaultAdmin();
    }

    @Transactional
    private void initRoles() {
        if (roleRepository.count() == 0) {
            List<Role> roles = List.of(
                    Role.builder().name("ROLE_ADMIN").build(),
                    Role.builder().name("ROLE_CURATOR").build(),
                    Role.builder().name("ROLE_EMPLOYEE").build()
            );
            roleRepository.saveAll(roles);
        }
    }

    @Transactional
    private void initDefaultAdmin() {
        String login = "admin";

        if (!employeeRepository.existsByLogin(login)) {
            Employee admin = Employee.builder()
                    .login(login)
                    .password(passwordEncoder.encode("admin"))
                    .email("admin@ad.min")
                    .roles(Set.of(roleRepository.getByName("ROLE_ADMIN")))
                    .firstName("admin")
                    .lastName("admin")
                    .patronymic("admin")
                    .build();

            employeeRepository.save(admin);
        }
    }
}
