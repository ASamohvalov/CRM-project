package com.srt.CRMBackend.repositories;

import com.srt.CRMBackend.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TokenRepository extends JpaRepository<Token, UUID> {
}
