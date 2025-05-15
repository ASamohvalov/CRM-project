package com.srt.CRMBackend.repositories.employee;

import com.srt.CRMBackend.models.employees.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, UUID> {
}
