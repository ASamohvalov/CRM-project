package com.srt.CRMBackend.repositories.employee;

import com.srt.CRMBackend.models.employees.Qualification;
import com.srt.CRMBackend.models.tasks.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, UUID> {
    @Query("""
        SELECT q FROM Qualification q
        JOIN FETCH JobTitle jt ON q.jobTitle.id = jt.id
    """)
    List<Qualification> findAllWithJobTitle();
}
