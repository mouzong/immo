package com.adacorp.immo.services;

import com.adacorp.immo.dto.ClientRequestDTO;
import com.adacorp.immo.model.Client;
import com.adacorp.immo.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> getClientById(Integer clientID) {
        return clientRepository.findById(clientID);
    }

    public String createClient(ClientRequestDTO clientAEnregistrer) {
       Client  cl1 = new Client();
       cl1.setNomComplet(clientAEnregistrer.getNomComplet());
       cl1.setEmail(clientAEnregistrer.getEmail());

       Client saved = clientRepository.save(cl1);
        return "Client enregistré avec succès : "+ saved;
    }
}
