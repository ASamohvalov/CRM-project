package com.srt.CRMBackend.mockmvc.utils;

import com.srt.CRMBackend.models.employees.JobTitle;
import com.srt.CRMBackend.models.employees.Qualification;
import com.srt.CRMBackend.repositories.JobTitleRepository;
import com.srt.CRMBackend.repositories.QualificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataFactory {
    private final JobTitleRepository jobTitleRepository;
    private final QualificationRepository qualificationRepository;

    public JobTitle saveJobTitle(JobTitle jobTitle) {
        return jobTitleRepository.save(jobTitle);
    }

    public Qualification saveQualification(Qualification qualification) {
        return qualificationRepository.save(qualification);
    }
}
