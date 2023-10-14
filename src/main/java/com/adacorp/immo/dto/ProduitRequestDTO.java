package com.adacorp.immo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProduitRequestDTO {
    private String nomProduit;
    private String description;
    private double prix;
    private double stock;
}
