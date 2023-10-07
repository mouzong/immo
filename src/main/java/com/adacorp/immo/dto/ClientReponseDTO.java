package com.adacorp.immo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientReponseDTO {
    private String nomComplet;
    private String email;
    private String username;
}
