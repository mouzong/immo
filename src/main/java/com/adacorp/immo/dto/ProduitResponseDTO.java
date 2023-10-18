package com.adacorp.immo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProduitResponseDTO {
    private String nom_produit;
    private String description;
    private double prix;
    private double stock;
}
