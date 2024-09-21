package sn.bmbank.api_bancaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.bmbank.api_bancaire.model.Telephone;
import sn.bmbank.api_bancaire.service.TelephoneService;

@RestController
@RequestMapping("/telephone/")
public class TelephoneController {
    @Autowired
    private TelephoneService telephoneService;

    /**
     * Endpoint pour créer une nouvelle transaction.
     * 
     * @param telephone La transaction à créer
     * @return La transaction effectuée et sauvegardée
     */
    @PostMapping("add")
    public ResponseEntity<Telephone> createTelephone(@RequestBody Telephone telephone) {
        try {
            Telephone newTelephone = telephoneService.addTelephone(telephone);
            return new ResponseEntity<>(newTelephone, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
}
