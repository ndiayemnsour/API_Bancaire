package sn.bmbank.api_bancaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.*;
import sn.bmbank.api_bancaire.model.*;
import sn.bmbank.api_bancaire.repository.CompteRepository;
import java.util.stream.*;

@Service
public class CompteService {
    @Autowired
    //Injection des dependances du repository 

    private CompteRepository compteRepository;

    //methodes pour recuperer tous les Compte
    /*public List<Compte> getAllCompte(){
        return compteRepository.findAll();
    }*/

    //Methode pour recuperer un satut  par son ID
    public Compte getCompteById(String id_compte){
        Optional<Compte> optionalCompte = compteRepository.findById(id_compte);
        return optionalCompte.orElse(null);
    }

    //Methode pour ajouter un Statut
    public Compte addCompte(Compte compte){
        return compteRepository.save(compte);

    }
    


    //methode pour la pagination
    public Page<Compte> getAllComptes(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return compteRepository.findAll(pageable);
    }

    //methode pour recuperer le solde d'un compte
    public Float getSoldeByNumeroCompte(String id_compte) {
        Optional<Compte> compte = compteRepository.findById_compte(id_compte);
        if (compte.isPresent()) {
            return compte.get().getSolde();
        } else {
            throw new RuntimeException("Compte non trouvé pour le numéro: " + id_compte);
        }
    }


}
