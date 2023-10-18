package com.adacorp.immo.services;

import com.adacorp.immo.dto.FactureRequestDTO;
import com.adacorp.immo.dto.FactureResponseDTO;
import com.adacorp.immo.exceptions.FactureNotFoundException;
import com.adacorp.immo.model.Client;
import com.adacorp.immo.model.Facture;
import com.adacorp.immo.repositories.ClientRepository;
import com.adacorp.immo.repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FactureService {
    private final FactureRepository factureRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public FactureService(FactureRepository factureRepository, ClientRepository clientRepository) {

        this.factureRepository = factureRepository;
        this.clientRepository = clientRepository;
    }

    public Facture createFacture(FactureRequestDTO facture, UUID clientID) {
        Facture facture1 = new Facture().builder()
                .montant_facture(facture.getMontant_facture())
                .build();
        Client client = clientRepository.findById(clientID)
                .orElseThrow(()-> new RuntimeException("Le client n'existe pas dans la BD"));

        facture1.setClientModel(client);

        return factureRepository.save(facture1);
    }

    public FactureResponseDTO getFactureById(UUID factureID) throws FactureNotFoundException {
        Facture facture1 = factureRepository.findById(factureID)
                .orElseThrow(()-> new FactureNotFoundException("Facture avec l'id:" +factureID+
                        "introuvable"));

        FactureResponseDTO facture1DTO = new FactureResponseDTO().builder()
                .montant_facture(facture1.getMontant_facture())
                .build();
        return facture1DTO;
    }
}
