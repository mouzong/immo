package com.adacorp.immo.controllers;

import com.adacorp.immo.dto.FactureRequestDTO;
import com.adacorp.immo.model.Facture;
import com.adacorp.immo.services.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/factures")
public class FactureController {

    private final FactureService factureService;
    @Autowired
    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    /**
     *
     * @param facture
     * @return la facture cree est retourne en reponse de la requete
     */
    @PostMapping("/create/{clientID}")
    public Facture createFacture(@RequestBody FactureRequestDTO facture, @PathVariable UUID clientID){

        return factureService.createFacture(facture, clientID);
    }

    @GetMapping("/get-all")
    public List<Facture> getAllFacture(){
        return null;
    }
}
