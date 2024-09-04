package sn.bmbank.api_bancaire.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.bmbank.api_bancaire.model.Client;
import sn.bmbank.api_bancaire.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/clients/")
public class ClientController {
    @Autowired

    private ClientService clientService;

    //EndPoint pour recuperer tous les Clients
    @GetMapping("all")
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }
    
    //Endpoint pour recuperer un Client par son ID
    @GetMapping("{id_client}")
    public Client getClientById(@PathVariable String id_client){
        return clientService.getClientById(id_client);
    }

    //Endpoint pour  ajouter un Client
    @PostMapping("add")
        public Client addClient (@RequestBody Client client){

        return clientService.addClient(client);
    }
    
}
