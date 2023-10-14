package com.adacorp.immo.services;

import com.adacorp.immo.dto.ClientRequestDTO;
import com.adacorp.immo.dto.ClientResponseDTO;
import com.adacorp.immo.exceptions.ClientNotFoundException;
import com.adacorp.immo.model.Client;
import com.adacorp.immo.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientResponseDTO getClientById(UUID clientID) throws ClientNotFoundException{
        Client cl1 = clientRepository.findById(clientID)
                .orElseThrow(() -> new ClientNotFoundException("Client avec l'id : "+clientID+
                        " introuvable"));

        ClientResponseDTO cl1DTO = new ClientResponseDTO().builder()
                .nomComplet(cl1.getNomComplet())
                .email(cl1.getEmail())
                .username(cl1.getUsername())
                .build();
        return cl1DTO;
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

    public ClientResponseDTO updateClientById(UUID clientID, ClientRequestDTO donneesClient)
            throws ClientNotFoundException {

        Client clientAModifier = clientRepository.findById(clientID)
                .orElseThrow(() -> new ClientNotFoundException("Client avec id: "+ clientID +
                        " Introuvable "));

        clientAModifier.setEmail(donneesClient.getEmail());
        clientAModifier.setNomComplet(donneesClient.getNomComplet());

        Client clientModifie = clientRepository.save(clientAModifier);

        ClientResponseDTO clientResponseDTO = new ClientResponseDTO().builder()
                .nomComplet(clientModifie.getNomComplet())
                .username(clientModifie.getUsername())
                .email(clientModifie.getEmail())
                .build();
        return clientResponseDTO;
    }
}
