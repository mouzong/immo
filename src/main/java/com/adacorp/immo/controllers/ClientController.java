package com.adacorp.immo.controllers;

import com.adacorp.immo.dto.ClientRequestDTO;
import com.adacorp.immo.model.Client;
import com.adacorp.immo.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clients/")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("{clientID}")
    public Optional<Client> getClientById(@PathVariable("clientID") Integer clientID){

        return clientService.getClientById(clientID);
    }

    @PostMapping("create-client")
    public String createClient(@RequestBody ClientRequestDTO clientAEnregistrer){
        return clientService.createClient(clientAEnregistrer);
    }


}
