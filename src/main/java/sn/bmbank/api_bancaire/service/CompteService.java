package sn.bmbank.api_bancaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import sn.bmbank.api_bancaire.model.Compte;
import sn.bmbank.api_bancaire.repository.CompteRepository;

@Service
public class CompteService {
    @Autowired
    //Injection des dependances du repository StatutRepository
    private CompteRepository compteRepository;

    //methodes pour recuperer tous les Statut
    public List<Compte> getAllCompte(){
        return compteRepository.findAll();
    }

    //Methode pour recuperer un satut  par son ID
    public Compte getCompteById(String id_compte){
        Optional<Compte> optionalCompte = compteRepository.findById(id_compte);
        return optionalCompte.orElse(null);
    }

    //Methode pour ajouter un Statut
    public Compte addCompte(Compte compte){
        return compteRepository.save(compte);

    }
}
