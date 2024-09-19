package sn.bmbank.api_bancaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.bmbank.api_bancaire.model.Adresse;
import sn.bmbank.api_bancaire.service.AdresseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/adresse/")
public class AdresseController {
    //Injection des dependance service
    @Autowired
    private AdresseService adresseService;

    @PostMapping("add")
    public ResponseEntity<Adresse> createAdresse(@RequestBody Adresse adresse) {
        try {
            Adresse newAdresse=adresseService.addAdresse(adresse);
            return new ResponseEntity<>(newAdresse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
}
