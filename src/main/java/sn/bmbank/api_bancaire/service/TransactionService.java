package sn.bmbank.api_bancaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.bmbank.api_bancaire.model.Compte;
import sn.bmbank.api_bancaire.model.Statut;
import sn.bmbank.api_bancaire.model.Transaction;
import sn.bmbank.api_bancaire.model.Type;
import sn.bmbank.api_bancaire.repository.CompteRepository;
import sn.bmbank.api_bancaire.repository.StatutRepository;
import sn.bmbank.api_bancaire.repository.TransactionRepository;
import sn.bmbank.api_bancaire.repository.TypeRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private StatutRepository statutRepository;
    /**
     * Effectue une transaction entre deux comptes.
     * 
     * @param transaction La transaction à effectuer
     * @return La transaction effectuée et sauvegardée
     * @throws Exception si l'un des comptes n'est pas trouvé ou si le solde est insuffisant
     */
    public Transaction executeTransaction(Transaction transaction) throws Exception {
        // Récupérer le compte débiteur et créditeur
        Compte compteDebiteur = compteRepository.findById(transaction.getCompte_debite().getId_compte())
                .orElseThrow(() -> new Exception("Compte débiteur non trouvé"));
        Compte compteCrediteur = compteRepository.findById(transaction.getCompte_credite().getId_compte())
                .orElseThrow(() -> new Exception("Compte créditeur non trouvé"));

        // Récupérer le type et statut de la transaction 
        Type type = typeRepository.findById(transaction.getType().getId_type())    
        .orElseThrow(() -> new Exception("Type pour la transaction non trouvé"));
        Statut statut = statutRepository.findById(transaction.getStatut().getId_statut())    
        .orElseThrow(() -> new Exception("Statut pour la transaction non trouvé"));

        // Vérifier que le compte débiteur a suffisamment de solde
        if (compteDebiteur.getSolde() < transaction.getMontant()) {
            throw new Exception("Solde insuffisant sur le compte débiteur");
        }

        // Débiter le compte débiteur
        compteDebiteur.setSolde(compteDebiteur.getSolde() - transaction.getMontant());

        // Créditer le compte créditeur
        compteCrediteur.setSolde(compteCrediteur.getSolde() + transaction.getMontant());

        // Sauvegarder les comptes mis à jour
        compteRepository.save(compteDebiteur);
        compteRepository.save(compteCrediteur);

        //Sauvegarder le type et le statut de la transaction

        typeRepository.save(type);
        statutRepository.save(statut);

        // Sauvegarder la transaction
        transaction.onCreate(); // Définit la date de transaction à la date actuelle
        return transactionRepository.save(transaction);
    }

}
