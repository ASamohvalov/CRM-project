package com.srt.CRMBackend.repositories.employee;

import com.srt.CRMBackend.models.employees.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface PointRepository extends JpaRepository<Point, UUID> {
    @Modifying
    @Query("""
        DELETE FROM Point p
        WHERE p.employee.id = :employeeId
    """)
    void deleteByEmployeeId(UUID employeeId);

    @Query("""
        SELECT p FROM Point p
        WHERE p.employee.id = :employeeId
    """)
    Optional<Point> findByEmployeeId(UUID employeeId);
}
