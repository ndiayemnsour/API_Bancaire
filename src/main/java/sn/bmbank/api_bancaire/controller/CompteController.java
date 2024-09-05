package sn.bmbank.api_bancaire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sn.bmbank.api_bancaire.model.Client;
import sn.bmbank.api_bancaire.model.Compte;
import sn.bmbank.api_bancaire.model.GestionnaireCompte;
import sn.bmbank.api_bancaire.model.Statut;
import sn.bmbank.api_bancaire.model.Type;
import sn.bmbank.api_bancaire.service.CompteService;

@RestController
@RequestMapping("/compte/")
public class CompteController {
     @Autowired
    // Injection de dépendance du service CompteService
    private CompteService compteService; 

    //Endpoint pour recuperer tous les Compte
    @GetMapping("all")
    public List<Compte> getAllCompte() {
        return compteService.getAllCompte();
    }

    //Endpoint pour recuperer un Compte par son ID
    @GetMapping("{id_compte}")
    public Compte getCompteById(@PathVariable String id_compte){
        return compteService.getCompteById(id_compte);
    }
    
    //Endpoint pour  ajouter un Compte
   /* @PostMapping("add")
    public Compte addCompte(@RequestBody Compte compte) {
        return compteService.addCompte(compte);
    }*/

    @PostMapping("add")
    public ResponseEntity<Compte> addCompte(@RequestBody Compte compte) {
        // Récupérer le client, statut, type et gestionnaire depuis la base de données
        Client client = clientRepository.findById(compte.getClient().getId_client())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        Statut statut = statutRepository.findById(compte.getStatut().getId_statut())
                .orElseThrow(() -> new ResourceNotFoundException("Statut not found"));
        Type type = typeRepository.findById(compte.getType().getId_type())
                .orElseThrow(() -> new ResourceNotFoundException("Type not found"));
        GestionnaireCompte gestionnaire = gestionnaireRepository.findById(compte.getGestionnaire_compte().getId_gestionnaire())
                .orElseThrow(() -> new ResourceNotFoundException("GestionnaireCompte not found"));

        // Assigner les objets récupérés au compte
        compte.setClient(client);
        compte.setStatut(statut);
        compte.setType(type);
        compte.setGestionnaire_compte(gestionnaire);

        // Persister le compte
        Compte newCompte = compteRepository.save(compte);
        
        return ResponseEntity.ok(newCompte);
    }


}
