package com.srt.CRMBackend.init;

import com.srt.CRMBackend.models.employees.Employee;
import com.srt.CRMBackend.models.employees.FullName;
import com.srt.CRMBackend.models.employees.Role;
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
    private final DefaultAdminInitialization defaultAdminInitialization;

    @Override
    public void run(String... args) throws Exception {
        initRoles();
        defaultAdminInitialization.init();
    }

    private void initRoles() {
        if (roleRepository.count() == 0) {
            List<Role> roles = List.of(
                    Role.builder().name("ROLE_ADMIN").build(),
                    Role.builder().name("ROLE_MANAGER").build(),
                    Role.builder().name("ROLE_EMPLOYEE").build()
            );
            roleRepository.saveAll(roles);
        }
    }
}
