package com.adacorp.immo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
<<<<<<< HEAD
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
=======
import jakarta.persistence.Id;
import lombok.*;
>>>>>>> a109e7cbc3f393e768c6178ef3faa850c42fe293

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Client {
    @Id
    @GeneratedValue
<<<<<<< HEAD
    private UUID clientID;
    private String nomComplet;
    private String email;


=======
    private Integer clientID;
    private String nomComplet;
    private String email;
>>>>>>> a109e7cbc3f393e768c6178ef3faa850c42fe293
}
