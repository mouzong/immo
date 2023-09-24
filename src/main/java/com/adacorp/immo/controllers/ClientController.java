package com.adacorp.immo.controllers;

import com.adacorp.immo.dto.ClientRequestDTO;
import com.adacorp.immo.model.Client;
<<<<<<< HEAD
import com.adacorp.immo.service.ClientService;
=======
import com.adacorp.immo.services.ClientService;
>>>>>>> a109e7cbc3f393e768c6178ef3faa850c42fe293
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clients/")
public class ClientController {

<<<<<<< HEAD
    /*
 Injection de la dependence du service (ClientService) dans le controleur (ClientContoller)
 */
=======
>>>>>>> a109e7cbc3f393e768c6178ef3faa850c42fe293
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
<<<<<<< HEAD
    }
    @PostMapping("create")
    public Client createClient(@RequestBody Client newClient){
        return clientService.createClient(newClient);
    }
=======
    }

    @GetMapping("{clientID}")
    public Optional<Client> getClientById(@PathVariable("clientID") Integer clientID){

        return clientService.getClientById(clientID);
    }

    @PostMapping("create-client")
    public String createClient(@RequestBody ClientRequestDTO clientAEnregistrer){
        return clientService.createClient(clientAEnregistrer);
    }


>>>>>>> a109e7cbc3f393e768c6178ef3faa850c42fe293
}
