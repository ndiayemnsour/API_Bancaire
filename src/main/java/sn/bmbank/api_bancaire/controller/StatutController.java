package sn.bmbank.api_bancaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.bmbank.api_bancaire.service.StatutService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import sn.bmbank.api_bancaire.model.*;
import java.util.List;

@RestController
@RequestMapping("/statut/all")
public class StatutController {
    @Autowired
    // Injection de dépendance du service StatutService
    private StatutService statutService; 

    //Endpoint pour recuperer tous les Statut
    @GetMapping
    public List<Statut> getAllStatut() {
        return statutService.getAllStatut();
    }

    //Endpoint pour recuperer un statut par son ID
    @GetMapping("{id_statut}")
    public Statut getStatutById(@PathVariable String id_statut){
        return statutService.getStatutById(id_statut);
    }
    
    //Endpoint pour  ajouter un Statut
    @PostMapping("POST/statut")
    public Statut addStatut(@RequestBody Statut statut) {
        return statutService.addStatut(statut);
    }

}
