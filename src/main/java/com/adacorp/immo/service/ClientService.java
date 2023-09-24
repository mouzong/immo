package com.adacorp.immo.service;

import com.adacorp.immo.model.Client;
import com.adacorp.immo.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
/*
 Injection de la dependence du repository (ClientRepository) dans le service (ClientService)
 */
    private final ClientRepository clientRepository;
//communication entre le service et le repository
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client newClient) {

        return clientRepository.save(newClient);
    }
}
