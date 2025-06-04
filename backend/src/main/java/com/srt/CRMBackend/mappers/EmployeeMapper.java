package com.srt.CRMBackend.mappers;

import com.srt.CRMBackend.DTO.employee.EmployeeDTO;
import com.srt.CRMBackend.models.employees.Employee;
import com.srt.CRMBackend.models.employees.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(target = "firstName", source = "fullName.firstName")
    @Mapping(target = "lastName", source = "fullName.lastName")
    @Mapping(target = "patronymic", source = "fullName.patronymic")
    @Mapping(target = "jobTitleName", source = "qualification.jobTitle.name")
    @Mapping(target = "qualificationName", source = "qualification.name")
    @Mapping(target = "rolesName", source = "roles", qualifiedByName = "rolesToRoleNames")
    EmployeeDTO toEmployeeDTO(Employee employee);

    @Named("rolesToRoleNames")
    default Set<String> rolesToRoleNames(Set<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }
}
