package sn.bmbank.api_bancaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.bmbank.api_bancaire.model.CarteBancaire;
import sn.bmbank.api_bancaire.model.Compte;
import sn.bmbank.api_bancaire.model.Statut;
import sn.bmbank.api_bancaire.model.Type;
import sn.bmbank.api_bancaire.repository.CarteBancaireRepository;
import sn.bmbank.api_bancaire.repository.CompteRepository;
import sn.bmbank.api_bancaire.repository.StatutRepository;
import sn.bmbank.api_bancaire.repository.TypeRepository;

@Service
public class CarteBancaireService {
    
    @Autowired
    private CarteBancaireRepository carteBancaireRepository;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private StatutRepository statutRepository;

    /**
     * Ajouter une carte en le retachant  a une comptes.
     * 
     * @param carte La transaction à effectuer
     * @return La transaction effectuée et sauvegardée
     * @throws Exception si l'un des comptes n'est pas trouvé ou si le solde est insuffisant
     */

     public CarteBancaire addCarte(CarteBancaire carte) throws Exception{

        // Récupérer le compte retaché a la carte
        Compte compte = compteRepository.findById(carte.getCompte().getIdCompte())
                .orElseThrow(() -> new Exception("Compte débiteur non trouvé"));

        // Récupérer le type et statut de la carte 
        Type type = typeRepository.findById(carte.getType().getIdType())    
        .orElseThrow(() -> new Exception("Type pour la transaction non trouvé"));
        Statut statut = statutRepository.findById(carte.getStatut().getIdStatut())    
        .orElseThrow(() -> new Exception("Statut pour la transaction non trouvé"));

        // Associer les entités a la carte
        carte.setType(type);
        carte.setStatut(statut);
        carte.setCompte(compte);

        return carteBancaireRepository.save(carte);
     }
}
