package com.adacorp.immo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agent-immo")
public class AgentImmo {
    private UUID agentImmoID;
    private String nom_agent_immo;
    private String email;

}
