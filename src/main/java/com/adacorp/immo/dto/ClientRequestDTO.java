package com.adacorp.immo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientRequestDTO {
    private String nom_complet;
    private String email;
    private String username;
    private String password;


}
