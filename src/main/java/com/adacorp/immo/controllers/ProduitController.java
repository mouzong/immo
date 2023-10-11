package com.adacorp.immo.controllers;

import com.adacorp.immo.dto.ProduitResponseDTO;
import com.adacorp.immo.exceptions.ProduitNotFoundException;
import com.adacorp.immo.model.Produit;
import com.adacorp.immo.services.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/produits/")
public class ProduitController {
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("{produitID}")
    public ProduitResponseDTO getProduitById(@PathVariable("produitID") UUID produitID)
        throws ProduitNotFoundException{
        return produitService.getProduitById(produitID);
    }

    @PostMapping("create-produit")
    public String createProduit(@RequestBody ProduitResponseDTO produitAEregistrer){
        return produitService.createProduit(produitAEregistrer);
    }

    @GetMapping("get-all")
    public List<Produit> getAllProduit(){
        return produitService.getAllProduit();
    }
}
