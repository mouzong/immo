package com.adacorp.immo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;
@Data
public class Produit {
    @Id
    @GeneratedValue
    private UUID produitID;
    private String nomProduit;
    private int quantiteProduit;
    private double prix;
}
