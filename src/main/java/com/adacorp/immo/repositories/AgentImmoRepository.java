package com.adacorp.immo.repositories;

import com.adacorp.immo.model.AgentImmo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgentImmoRepository extends JpaRepository<AgentImmo, UUID> {
}
