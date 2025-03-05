package com.srt.CRMBackend.repositories;

import com.srt.CRMBackend.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    boolean existsByLogin(String login);
    boolean existsByEmail(String email);
}
