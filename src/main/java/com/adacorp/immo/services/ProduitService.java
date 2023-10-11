package com.adacorp.immo.services;

import com.adacorp.immo.dto.ProduitResponseDTO;
import com.adacorp.immo.exceptions.ProduitNotFoundException;
import com.adacorp.immo.model.Produit;
import com.adacorp.immo.repositories.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProduitService {
    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public ProduitResponseDTO getProduitById(UUID produitID) throws ProduitNotFoundException{
        Produit pdt = produitRepository.findById(produitID)
                .orElseThrow(()-> new ProduitNotFoundException("Produit avec l'id :"+produitID+ "Introuvable"));

        ProduitResponseDTO pdtDTO = new ProduitResponseDTO().builder()
                .nomProduit(pdt.getNomProduit())
                .description(pdt.getDescription())
                .prix(pdt.getPrix())
                .stock(pdt.getStock())
                .build();

        return pdtDTO;
    }

    public String createProduit(ProduitResponseDTO produitAEnregister){
        Produit pdt = new Produit();
        pdt.setNomProduit(produitAEnregister.getNomProduit());
        pdt.setDescription(produitAEnregister.getDescription());
        pdt.setPrix(produitAEnregister.getPrix());
        pdt.setStock(produitAEnregister.getStock());

        Produit saved = produitRepository.save(pdt);
         return "Produit enregistré avec succès" + saved;
    }

    public List<Produit> getAllProduit() {
        return produitRepository.findAll();
    }

    public String deleteProduitById(UUID produitID) throws ProduitNotFoundException{
        Produit produitASupprimer = produitRepository.findById(produitID)
                .orElseThrow(()-> new ProduitNotFoundException("Produit avec l'id" +produitID+
                        "Introuvable"));

        produitRepository.delete(produitASupprimer);

        return "Produit avec l'id :" +produitID+ "supprimé avec succès.";
    }


}
