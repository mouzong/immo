package com.adacorp.immo.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Client {
    private String nomComplet;
    private String email;
}
