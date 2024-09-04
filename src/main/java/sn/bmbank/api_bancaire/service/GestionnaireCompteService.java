package sn.bmbank.api_bancaire.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.bmbank.api_bancaire.model.GestionnaireCompte;
import sn.bmbank.api_bancaire.repository.GestionnaireCompteRepository;

@Service
public class GestionnaireCompteService {
     @Autowired
    //Injection des dependances du repository StatutRepository
    private GestionnaireCompteRepository gestionnaireCompteRepository;

    //methodes pour recuperer tous les Statut
    public List<GestionnaireCompte> getAllGestionnaire(){
        return gestionnaireCompteRepository.findAll();
    }

    //Methode pour recuperer un satut  par son ID
    public GestionnaireCompte getGestionnaireById(String id_gestionnaire){
        Optional<GestionnaireCompte> optionalGestionnaire = gestionnaireCompteRepository.findById(id_gestionnaire);
        return optionalGestionnaire.orElse(null);
    }

    //Methode pour ajouter un Statut
    public GestionnaireCompte addGestionnaire(GestionnaireCompte gestionnaireCompte){
        return gestionnaireCompteRepository.save(gestionnaireCompte);

    }
}
