package com.adacorp.immo.controllers;

import com.adacorp.immo.model.Facture;
import com.adacorp.immo.services.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/create")
    public Facture createFacture(@RequestBody Facture facture){
        return factureService.createFacture(facture);
    }

    @GetMapping("/get-all")
    public List<Facture> getAllFacture(){
        return null;
    }
}
