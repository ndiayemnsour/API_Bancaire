package sn.bmbank.api_bancaire.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.bmbank.api_bancaire.model.Transaction;
import sn.bmbank.api_bancaire.service.TransactionService;

@RestController
@RequestMapping("/transaction/")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    /**
     * Endpoint pour créer une nouvelle transaction.
     * 
     * @param transaction La transaction à créer
     * @return La transaction effectuée et sauvegardée
     */
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        try {
            Transaction newTransaction = transactionService.executeTransaction(transaction);
            return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint pour afficher toutes les transactions
    @GetMapping("all")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    

}
