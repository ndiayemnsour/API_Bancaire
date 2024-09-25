package sn.bmbank.api_bancaire.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.bmbank.api_bancaire.model.Type;
import sn.bmbank.api_bancaire.repository.TypeRepository;


@Service
public class TypeService {
    @Autowired

    private TypeRepository typeRepository;

    //methodes pour recuperer tous les
    public List <Type> getAllType(){
        return typeRepository.findAll();
    }

     //Methode pour recuperer un Type  par son ID
    public Type getTypeById(String id_type){
        Optional <Type> optionalType = typeRepository.findById(id_type);
        return optionalType.orElse(null);
    }

    //methode pour recuperer le nom des type
    public List<String> getAllTypeNames() {
        return typeRepository.findAllNomTypes();
    }

    //Methode pour ajouter un Statut
    public Type addType(Type type){
        return typeRepository.save(type);

    }
}
