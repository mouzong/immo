package com.adacorp.immo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue
    private UUID clientID;
    private String nomComplet;
    private String email;
    private String username;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "clientModel")
    private List<Facture> factureList;
    //private boolean isDeleted;
}
