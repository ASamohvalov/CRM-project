package com.srt.CRMBackend.repositories;

import com.srt.CRMBackend.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> getUserByLogin(String login);
    boolean existsByLogin(String login);
}
