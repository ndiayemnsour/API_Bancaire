package sn.bmbank.api_bancaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import sn.bmbank.api_bancaire.model.Client;
import sn.bmbank.api_bancaire.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    //Injection dependance repository
    private ClientRepository clientRepository;

    //methodes pour recuperer tous les Statut
    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }

    //Methode pour recuperer un satut  par son ID
    public Client getClientById(String id_client){
        Optional<Client> optionalClient = clientRepository.findById(id_client);
        return optionalClient.orElse(null);
    }

    //Methode pour ajouter un Statut
    public Client addClient(Client client){
        return clientRepository.save(client);

    }
    
}
