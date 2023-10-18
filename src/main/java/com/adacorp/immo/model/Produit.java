package com.adacorp.immo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue
    private UUID produitID;
    private String nom_produit;
    private String description;
    private double prix;
    private double stock;

}
