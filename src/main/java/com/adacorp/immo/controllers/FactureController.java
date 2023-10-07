package com.adacorp.immo.controllers;

import com.adacorp.immo.model.Facture;
import com.adacorp.immo.services.FactureService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/factures/")
public class FactureController {
    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    @PostMapping("create")
    public Facture createFacture(@RequestBody Facture facture){
        return factureService.createFacture(facture);
    }
}
