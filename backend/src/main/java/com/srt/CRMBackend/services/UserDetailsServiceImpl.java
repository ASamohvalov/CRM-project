package com.srt.CRMBackend.services;

import com.srt.CRMBackend.exceptions.LoginNotFoundException;
import com.srt.CRMBackend.models.Employee;
import com.srt.CRMBackend.models.auth.UserDetailsImpl;
import com.srt.CRMBackend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = userRepository.getUserByLogin(username)
                .orElseThrow(() -> new LoginNotFoundException("user not found with login - " + username));
        return new UserDetailsImpl(employee);
    }
}
