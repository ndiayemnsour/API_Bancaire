package sn.bmbank.api_bancaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.bmbank.api_bancaire.model.Adresse;
import sn.bmbank.api_bancaire.model.Client;
import sn.bmbank.api_bancaire.model.Telephone;
import sn.bmbank.api_bancaire.repository.ClientRepository;
import sn.bmbank.api_bancaire.repository.TelephoneRepository;

@Service
public class TelephoneService {
    //Injection dependance repository
    @Autowired
    private TelephoneRepository telephoneRepository;

     @Autowired
    private ClientRepository clientRepository;

    /**
     * Ajouter une Adresse 
     * @param telephone
     * @return
     * @throws Exception
     */

     public Telephone addTelephone(Telephone telephone)throws Exception{
        //recuperer le client a lie a un numero 
        Client client = clientRepository.findById(telephone.getClient().getIdClient())
        .orElseThrow(() -> new Exception("Le client non trouvé"));

        telephone.setClient(client);
        return telephoneRepository.save(telephone);
     }
    
}
