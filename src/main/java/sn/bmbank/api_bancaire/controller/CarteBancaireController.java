package sn.bmbank.api_bancaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.bmbank.api_bancaire.model.CarteBancaire;
import sn.bmbank.api_bancaire.service.CarteBancaireService;

@RestController
@RequestMapping("/carte/")
public class CarteBancaireController {
    
    @Autowired
    private CarteBancaireService carteBancaireService;

    /**
     * Endpoint pour créer une carte .
     * 
     * @param carte la carte est creer 
     * @return La transaction effectuée et sauvegardée
     */
    @PostMapping("add")
    public ResponseEntity<CarteBancaire> createCarte(@RequestBody CarteBancaire carte){
        try {
            CarteBancaire newCarteBancaire = carteBancaireService.addCarte(carte);
            return new ResponseEntity<>(newCarteBancaire, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
