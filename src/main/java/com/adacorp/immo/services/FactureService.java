package com.adacorp.immo.services;

import com.adacorp.immo.dto.FactureRequestDTO;
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

    public Facture createFacture(FactureRequestDTO facture) {
        Facture facture1 = new Facture().builder()
                .montantFacture(facture.getMontantFacture())
                .build();
        return factureRepository.save(facture1);
    }
}
