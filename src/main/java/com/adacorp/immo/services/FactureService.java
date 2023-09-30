package com.adacorp.immo.services;

import com.adacorp.immo.model.Facture;
import com.adacorp.immo.repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactureService {
    private final FactureRepository factureRepository;

    @Autowired
    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    public Facture createFacture(Facture facture) {
        return factureRepository.save(facture);
    }
}
