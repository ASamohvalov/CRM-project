package com.srt.CRMBackend.service.auth;

import com.srt.CRMBackend.auth.UserDetailsImpl;
import com.srt.CRMBackend.models.employees.Employee;
import com.srt.CRMBackend.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByLoginWithRoles(username)
                .orElseThrow(() -> new UsernameNotFoundException("работник не найден"));
        return new UserDetailsImpl(employee);
    }
}
