package sn.bmbank.api_bancaire.repository;

import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.bmbank.api_bancaire.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    // Méthode pour trouver les transactions par compte débiteur
    //Page<Transaction> findByCompte_debite_IdCompte(String idCompte, Pageable pageable);



}
