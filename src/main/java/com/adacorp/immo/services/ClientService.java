package com.adacorp.immo.services;

import com.adacorp.immo.dto.ClientReponseDTO;
import com.adacorp.immo.dto.ClientRequestDTO;
import com.adacorp.immo.exceptions.ClientNotFoundException;
import com.adacorp.immo.model.Client;
import com.adacorp.immo.repositories.ClientRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientReponseDTO getClientById(UUID clientID) {
        Client cl2 = clientRepository.findById(clientID)
                .orElseThrow(()->new RuntimeException("Le client n'existe pas"));
        ClientReponseDTO clientreponse = new ClientReponseDTO().builder()
                .nomComplet(cl2.getNomComplet())
                .email(cl2.getEmail())
                .username(cl2.getUsername())
                .build();
        return clientreponse;
    }

    public String createClient(ClientRequestDTO clientAEnregistrer) {
       Client  cl1 = new Client();
       cl1.setNomComplet(clientAEnregistrer.getNomComplet());
       cl1.setEmail(clientAEnregistrer.getEmail());
       cl1.setUsername(clientAEnregistrer.getUsername());
       cl1.setPassword(clientAEnregistrer.getPassword());

       Client saved = clientRepository.save(cl1);
        return "Client enregistré avec succès : "+ saved;
    }

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public String deleteClientById(UUID clientID) throws ClientNotFoundException {

        Client clientASupprimer = clientRepository.findById(clientID)
                .orElseThrow(() -> new ClientNotFoundException("Client avec id: "+ clientID +
                        " Introuvable "));

        clientRepository.delete(clientASupprimer);

        return "Client avec l'ID: "+ clientID + " a été supprimé avec succès";
    }
}
