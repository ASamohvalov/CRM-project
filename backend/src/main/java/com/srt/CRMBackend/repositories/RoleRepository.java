package com.srt.CRMBackend.repositories;

import com.srt.CRMBackend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    Role getByName(String name);
}
