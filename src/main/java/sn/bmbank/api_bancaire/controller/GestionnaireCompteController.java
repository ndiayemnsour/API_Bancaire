package sn.bmbank.api_bancaire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sn.bmbank.api_bancaire.model.GestionnaireCompte;
import sn.bmbank.api_bancaire.service.GestionnaireCompteService;

@RestController
@RequestMapping("/gestionnaire/")
public class GestionnaireCompteController {
     @Autowired
    // Injection de dépendance du service StatutService
    private GestionnaireCompteService gestionnaireCompteService; 

    //Endpoint pour recuperer tous les Statut
    @GetMapping("all")
    public List<GestionnaireCompte> getAllGestionnaire() {
        return gestionnaireCompteService.getAllGestionnaire();
    }

    //Endpoint pour recuperer un statut par son ID
    @GetMapping("{id_gestionnaire}")
    public GestionnaireCompte getGestionnaireById(@PathVariable String id_gestionnaire){
        return gestionnaireCompteService.getGestionnaireById(id_gestionnaire);
    }
    
    //Endpoint pour  ajouter un Statut
    @PostMapping("add")
    public GestionnaireCompte addGestionnaire(@RequestBody GestionnaireCompte gestionnaireCompte) {
        return gestionnaireCompteService.addGestionnaire(gestionnaireCompte);
    }
}
