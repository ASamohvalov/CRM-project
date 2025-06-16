package com.srt.CRMBackend.controllers.privilege;

import com.srt.CRMBackend.DTO.admin.AddEmployeeRequest;
import com.srt.CRMBackend.DTO.admin.JobTitleRequest;
import com.srt.CRMBackend.DTO.admin.AddQualificationRequest;
import com.srt.CRMBackend.services.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Tag(name = "админы", description = "все методы доступны только админам")
public class AdminController {
    private final AdminService adminService;

    @Operation(description = "регистрация работников, виды ролей (ROLE_EMPLOYEE, ROLE_ADMIN, ROLE_MANAGER)")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка валидации по полю",
                    content = @Content(examples = @ExampleObject(
                            value = """
                                        {
                                          "errors": {
                                            "role": "некорректная роль",
                                            "login": "этот логин уже занят",
                                            "email": "эта почта уже используется",
                                            "qualification": "неверный идентификатор квалификации"
                                          }
                                        }
                                    """
                    ))
            ),
            @ApiResponse(
                    responseCode = "200",
                    description = "Работник успешно добавлен",
                    content = @Content(examples = @ExampleObject(
                            value = """
                                        {
                                          "message": "работник успешно добавлен"
                                        }
                                    """
                    ))
            )
    })
    @PostMapping("/add_employee")
    public Map<String, String> addEmployee(@Valid @RequestBody AddEmployeeRequest request) {
        adminService.addEmployee(request);
        return Map.of("message", "работник успешно добавлен");
    }

    @PostMapping("/add_job_title")
    public Map<String, String> addJobTitle(@Valid @RequestBody JobTitleRequest request) {
        adminService.addJobTitle(request);
        return Map.of("message", "должность успешно добавлена");
    }

    @PostMapping("/add_qualification")
    public Map<String, String> addQualification(@Valid @RequestBody AddQualificationRequest request) {
        adminService.addQualification(request);
        return Map.of("message", "квалификация успешно добавлена");
    }

    @Operation(description = "удаление должности")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка удаления (должность используется в квалификации)",
                    content = @Content(examples = @ExampleObject(
                            value = """
                                        {
                                            "message": "для удаления должности необходимо удалить зависящие квалификации"
                                        }
                                    """
                    ))
            ),
            @ApiResponse(
                    responseCode = "200",
                    description = "Работник успешно добавлен",
                    content = @Content(examples = @ExampleObject(
                            value = """
                                        {
                                          "message": "должность успешно удалена"
                                        }
                                    """
                    ))
            )
    })
    @DeleteMapping("/delete/job_title/{jobTitleId}")
    public Map<String, String> deleteJobTitle(@PathVariable UUID jobTitleId) {
        adminService.deleteJobTitle(jobTitleId);
        return Map.of("message", "должность успешно удалена");
    }

    @Operation(description = "удаление квалификации")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка удаления (должность используется в квалификации)",
                    content = @Content(examples = @ExampleObject(
                            value = """
                                        {
                                            "message": "для удаления квалификации необходимо изменить должности сотрудникам с такой квалификацией"
                                        }
                                    """
                    ))
            ),
            @ApiResponse(
                    responseCode = "200",
                    description = "Работник успешно добавлен",
                    content = @Content(examples = @ExampleObject(
                            value = """
                                        {
                                          "message": "квалификация успешно удалена"
                                        }
                                    """
                    ))
            )
    })
    @DeleteMapping("/delete/qualification/{qualificationId}")
    public Map<String, String> deleteQualification(@PathVariable UUID qualificationId) {
        adminService.deleteQualification(qualificationId);
        return Map.of("message", "квалификация успешно удалена");
    }

//    todo
//    @DeleteMapping("/delete/employee/{employeeId}")
//    public Map<String, String> deleteEmployee(@PathVariable UUID employeeId) {
//        adminService.deleteEmployee(employeeId);
//        return Map.of("message", "работник успешно удален");
//    }
}
