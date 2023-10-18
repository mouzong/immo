package com.adacorp.immo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "facture")
public class Facture {
    @Id
    @GeneratedValue
    private UUID factureID;
    private double montant_facture;

    @ManyToOne
    @JoinColumn(name = "clientID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client clientModel;

}
