package com.adacorp.immo.model;

import java.util.Objects;

public class Client {
    private String nomComplet;
    private String email;

    public Client(String nomComplet, String email) {
        this.nomComplet = nomComplet;
        this.email = email;
    }

    public Client() {
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(nomComplet, client.nomComplet) && Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomComplet, email);
    }

    @Override
    public String toString() {
        return "Client{" +
                "nomComplet='" + nomComplet + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
