package com.srt.CRMBackend.services.employee;

import java.util.UUID;

public interface EmployeeTaskService {
    void takeTask(UUID taskId);
    void saveEmployeeTask(UUID employeeId, UUID taskId);
}
