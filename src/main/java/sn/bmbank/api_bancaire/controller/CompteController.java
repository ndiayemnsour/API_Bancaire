package sn.bmbank.api_bancaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import sn.bmbank.api_bancaire.model.*;
import sn.bmbank.api_bancaire.service.CompteService;

@RestController
@RequestMapping("/accounts/")
public class CompteController {
    // Injection de dépendance du service CompteService
     @Autowired
    private CompteService compteService; 

    //private CompteRepository compteRepository;
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
    public  ResponseEntity<Compte> addCompte(@RequestBody Compte compte) {
        try {
            Compte newCompte = compteService.addCompte(compte);
            System.err.println(newCompte);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCompte);
        } catch (Exception e) {
            
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    //methode pour retourner Compte
    
    @GetMapping("all")
    public Page<Compte> getAllComptes(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size) {
        return compteService.getAllComptes(page, size);
    }

    //Endpoint pour recuperer un solde d'un compte
    // @GetMapping("{id_compte}/balance")
    // public Float getSolde(@PathVariable String id_compte) {
    //     return compteService.getSoldeByIdCompte(id_compte);
    // }

    //Endpoint pour recuperer un solde d'un compte
    // @GetMapping("{numero_compte}/balance")
    // public Float getSolde(@PathVariable Integer numero_compte) {
    //     return compteService.getSoldeByNumeroCompte(numero_compte);
    // }

}
