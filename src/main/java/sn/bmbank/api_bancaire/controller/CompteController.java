package sn.bmbank.api_bancaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sn.bmbank.api_bancaire.model.*;
import sn.bmbank.api_bancaire.service.CompteService;

@RestController
@RequestMapping("/accounts/")
public class CompteController {
    // Injection de dépendance du service CompteService
     @Autowired
    private CompteService compteService; 

    //Endpoint pour recuperer un Compte par son ID
    @GetMapping("{id_compte}")
    public Compte getCompteById(@PathVariable String id_compte){
        return compteService.getCompteById(id_compte);
    }
    
    //methode pour retourner Compte
    
    @GetMapping("all")
    public Page<Compte> getAllComptes(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size) {
        return compteService.getAllComptes(page, size);
    }


    //Endpoint pour recuperer un solde d'un compte par le numero du compte
    @GetMapping("{numeroCompte}/balance")
    public Float getSoldeByNumeroCompte(@PathVariable Integer numeroCompte) {
        return compteService.getSoldeByNumeroCompte(numeroCompte);
    }

    /**
     * Endpoint pour créer une nouvelle compte.
     * 
     * @param compte La transaction à créer
     * @return La transaction effectuée et sauvegardée
     */
    @PostMapping("add")
    public ResponseEntity<Compte> createCompte(@RequestBody Compte compte){
        try {
            Compte newCompte = compteService.addCompte(compte);
            return new ResponseEntity<>(newCompte, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    

}
