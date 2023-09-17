package com.adacorp.immo.controllers;

import com.adacorp.immo.model.Client;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clients/")
public class ClientController {
    Client client1 = new Client("John SNOW","johnsnow@adacorp.com");

    @GetMapping("get-client")
    public Client getClientById(){

        return client1;
    }

    @PostMapping("create-client")
    public String createClient(){
        return "Endpoint pour creer un client";
    }

    @PutMapping("edit-client")
    public String editClient(){
        return "Endpoint pour modifier un Client";
    }

    @DeleteMapping("delete-client")
    public String deleteCLient(){
        return "Endpoint pour delete un client";
    }

}
