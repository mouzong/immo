package com.adacorp.immo.services;

import com.adacorp.immo.model.Facture;
import com.adacorp.immo.repositories.FactureRepository;
import org.springframework.stereotype.Service;

@Service
public class FactureService {
    public final FactureRepository factureRepository;

    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }


    public Facture createFacture(Facture facture) {
        return factureRepository.save(facture);
    }
}
