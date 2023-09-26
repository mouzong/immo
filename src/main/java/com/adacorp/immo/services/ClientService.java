package com.adacorp.immo.services;

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

    public Optional<Client> getClientById(UUID clientID) {
        return clientRepository.findById(clientID);
    }

    public String createClient(ClientRequestDTO clientAEnregistrer) {
       Client  cl1 = new Client();
       cl1.setNomComplet(clientAEnregistrer.getNomComplet());
       cl1.setEmail(clientAEnregistrer.getEmail());

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
