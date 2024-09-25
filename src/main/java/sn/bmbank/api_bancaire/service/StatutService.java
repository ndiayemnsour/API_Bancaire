package sn.bmbank.api_bancaire.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.bmbank.api_bancaire.repository.*;
import sn.bmbank.api_bancaire.model.*;
import java.util.*;

@Service
public class StatutService {
    @Autowired
    //Injection des dependances du repository StatutRepository
    private StatutRepository statutRepository;

    //methodes pour recuperer tous les Statut
    public List<Statut> getAllStatut(){
        return statutRepository.findAll();
    }

    //Methode pour recuperer un satut  par son ID
    public Statut getStatutById(String id_statut){
        Optional<Statut> optionalStatut = statutRepository.findById(id_statut);
        return optionalStatut.orElse(null);
    }

    //Methode pour recuperer le nom des statut
    public List<String> getAllStatutName(){
        return statutRepository.findAllNomStatut();
    }

    //Methode pour ajouter un Statut
    public Statut addStatut(Statut statut){
        return statutRepository.save(statut);

    }
}
