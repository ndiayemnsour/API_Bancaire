package sn.bmbank.api_bancaire.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import sn.bmbank.api_bancaire.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    
    //Page<Transaction> findByNumero_compte(Integer numero_compte, Pageable pageable);
}
