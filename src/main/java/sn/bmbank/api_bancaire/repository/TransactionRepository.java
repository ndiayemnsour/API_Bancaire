package sn.bmbank.api_bancaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.bmbank.api_bancaire.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {



}
