package sn.bmbank.api_bancaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.bmbank.api_bancaire.model.Adresse;
import sn.bmbank.api_bancaire.model.Client;
import sn.bmbank.api_bancaire.repository.*;

@Service
public class AdresseService {
    //Injection des dependances repository

    @Autowired
    private AdresseRepository adresseRepository;

    @Autowired
    private ClientRepository clientRepository;

    /**
     * Ajouter une Adresse 
     * @param adresse
     * @return
     * @throws Exception
     */

     public Adresse addAdresse(Adresse adresse)throws Exception{
        //recuperer le client a lie pour cette adresse
        Client client = clientRepository.findById(adresse.getClient().getIdClient())
        .orElseThrow(() -> new Exception("Le client non trouvé"));

        adresse.setClient(client);
        return adresseRepository.save(adresse);
     }
}
