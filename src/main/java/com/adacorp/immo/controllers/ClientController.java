package com.adacorp.immo.controllers;

import com.adacorp.immo.dto.ClientRequestDTO;
import com.adacorp.immo.dto.ClientResponseDTO;
import com.adacorp.immo.exceptions.ClientNotFoundException;
import com.adacorp.immo.model.Client;
import com.adacorp.immo.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clients/")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("{clientID}")
    public Optional<Client> getClientById(@PathVariable("clientID") UUID clientID){

        return clientService.getClientById(clientID);
    }

    /**
     * Endpoint pour la creation d'un client
     * @param clientAEnregistrer
     * @return
     */
    @PostMapping("create-client")
    public String createClient(@RequestBody ClientRequestDTO clientAEnregistrer){
        return clientService.createClient(clientAEnregistrer);
    }

    @GetMapping("get-all")
    public List<Client> getAllClients(){

        return clientService.getAllClient();
    }

    @DeleteMapping("{clientID}")
    public String deleteClientById(@PathVariable("clientID") UUID clientID) throws ClientNotFoundException {
        return clientService.deleteClientById(clientID);

    }

    @PutMapping("{clientID}")
    public ClientResponseDTO updateClientById(@PathVariable("clientID") UUID clientID,
                                              @RequestBody ClientRequestDTO clientAmodifier
    ) throws ClientNotFoundException {
        return clientService.updateClientById(clientID, clientAmodifier);

    }



}
