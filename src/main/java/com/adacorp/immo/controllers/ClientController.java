package com.adacorp.immo.controllers;

import com.adacorp.immo.model.Client;
import com.adacorp.immo.service.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clients/")
public class ClientController {

    /*
 Injection de la dependence du service (ClientService) dans le controleur (ClientContoller)
 */
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("create")
    public Client createClient(@RequestBody Client newClient){
        return clientService.createClient(newClient);
    }
}
