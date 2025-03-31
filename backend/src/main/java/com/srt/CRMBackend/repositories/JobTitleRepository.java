package com.srt.CRMBackend.repositories;

import com.srt.CRMBackend.models.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, UUID> {
    boolean existsByName(String name);
}
