package sn.bmbank.api_bancaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.bmbank.api_bancaire.model.Compte;
import sn.bmbank.api_bancaire.model.Transaction;
import sn.bmbank.api_bancaire.repository.CompteRepository;
import sn.bmbank.api_bancaire.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CompteRepository compteRepository;

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

        // Sauvegarder la transaction
        transaction.onCreate(); // Définit la date de transaction à la date actuelle
        return transactionRepository.save(transaction);
    }

}
