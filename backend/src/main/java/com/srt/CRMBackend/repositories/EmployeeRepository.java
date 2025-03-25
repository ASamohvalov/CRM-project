package com.srt.CRMBackend.repositories;

import com.srt.CRMBackend.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.roles er LEFT JOIN FETCH er.role WHERE e.login = :login")
    Optional<Employee> findByLoginWithRoles(@Param("login") String login);

    boolean existsByLogin(String login);
    boolean existsByEmail(String email);

    Optional<Employee> findByLogin(String login);

    @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.roles er LEFT JOIN FETCH er.role LEFT JOIN FETCH e.jobTitle WHERE login = :login")
    Employee getByLoginWithRolesAndJobTitle(String login);
}
