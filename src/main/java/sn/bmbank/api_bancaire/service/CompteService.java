package sn.bmbank.api_bancaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.*;
import sn.bmbank.api_bancaire.model.*;
import sn.bmbank.api_bancaire.repository.ClientRepository;
import sn.bmbank.api_bancaire.repository.CompteRepository;
import sn.bmbank.api_bancaire.repository.GestionnaireCompteRepository;
import sn.bmbank.api_bancaire.repository.StatutRepository;
import sn.bmbank.api_bancaire.repository.TypeRepository;

@Service
public class CompteService {
    //Injection des dependances du repository 
    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private StatutRepository statutRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private GestionnaireCompteRepository gestionnaireCompteRepository;

    //methodes pour recuperer tous les Compte
    /*public List<Compte> getAllCompte(){
        return compteRepository.findAll();
    }*/

    //Methode pour recuperer un Compte  par son ID
    public Compte getCompteById(String id_compte){
        Optional<Compte> optionalCompte = compteRepository.findById(id_compte);
        return optionalCompte.orElse(null);
    }

    /**
     *Ajouter un compte.
     * 
     * @param compte La transaction à effectuer
     * @return La transaction effectuée et sauvegardée
     * @throws Exception si l'un des comptes n'est pas trouvé ou si le solde est insuffisant
     */
    public Compte addCompte(Compte compte) throws Exception {
        // Récupérer le type de compte
        Type type = typeRepository.findById(compte.getType().getIdType())
                .orElseThrow(() -> new Exception("Type du compte non trouvé"));

        // Récupérer le statut de compte
        Statut statut = statutRepository.findById(compte.getStatut().getIdStatut())
                .orElseThrow(() -> new Exception("Statut du compte non trouvé"));

        // Récupérer le client
        Client client = clientRepository.findById(compte.getClient().getIdClient())
                .orElseThrow(() -> new Exception("Client non trouvé"));

        // Récupérer le gestionnaire de compte
        GestionnaireCompte gestionnaireCompte = gestionnaireCompteRepository.findById(compte.getGestionnaire().getIdGestionnaire())
                .orElseThrow(() -> new Exception("Gestionnaire du compte non trouvé"));

        // Associer les entités au compte
        compte.setType(type);
        compte.setStatut(statut);
        compte.setClient(client);
        compte.setGestionnaire(gestionnaireCompte);
        
        // Sauvegarder le compte
        return compteRepository.save(compte);
    }
    


    //methode pour la pagination
    public Page<Compte> getAllComptes(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return compteRepository.findAll(pageable);
    }

    //methode pour recuperer le solde d'un compte par son ID
    // public Float getSoldeByIdCompte(String id_compte) {
    //     Optional<Compte> compte = compteRepository.findById_compte(id_compte);
    //     if (compte.isPresent()) {
    //         return compte.get().getSolde();
    //     } else {
    //         throw new RuntimeException("Compte non trouvé pour le numéro: " + id_compte);
    //     }
    // }

    //methode pour recuperer le solde d'un compte par son numero_compte
    // public Float getSoldeByNumeroCompte(Integer numero_compte) {
    //     Optional<Compte> compte = compteRepository.findByNumero_compte(numero_compte);
    //     if (compte.isPresent()) {
    //         return compte.get().getSolde();
    //     } else {
    //         throw new RuntimeException("Compte non trouvé pour le numéro: " + numero_compte);
    //     }
    // }


    

}
