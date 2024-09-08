package sn.bmbank.api_bancaire.controller;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.web.bind.annotation.*;
import sn.bmbank.api_bancaire.model.*;
import sn.bmbank.api_bancaire.service.CompteService;

@RestController
@RequestMapping("/accounts/")
public class CompteController {
     @Autowired
    // Injection de dépendance du service CompteService
    private CompteService compteService; 

    private PagedResourcesAssembler<Compte> pagedResourcesAssembler;

    //Endpoint pour recuperer tous les Compte
    /*@GetMapping("all")
    public List<Compte> getAllCompte() {
        return compteService.getAllCompte();
    }*/

    //Endpoint pour recuperer un Compte par son ID
    @GetMapping("{id_compte}")
    public Compte getCompteById(@PathVariable String id_compte){
        return compteService.getCompteById(id_compte);
    }
    
    //Endpoint pour  ajouter un Compte
   @PostMapping("add")
    public Compte addCompte(@RequestBody Compte compte) {
        return compteService.addCompte(compte);
    }

    //methode pour retourner Compte
    
    @GetMapping("all")
    public Page<Compte> getAllComptes(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size) {
        return compteService.getAllComptes(page, size);
    }

    //Endpoint pour recuperer un solde d'un compte
    @GetMapping("GET /accounts/{id_compte}/balance")
    public Float getSolde(@PathVariable String id_compte) {
        return compteService.getSoldeByNumeroCompte(id_compte);
    }

}
