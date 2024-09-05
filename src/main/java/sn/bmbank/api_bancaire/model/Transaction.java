package sn.bmbank.api_bancaire.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;



@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @Getter
    @Setter
    private String id_transaction;

    @PrePersist
    public void generateShortUUID(){
        this.id_transaction=UUID.randomUUID().toString().substring(0,6);
    }
    
    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Float montant;

    @Getter
    @Setter
    private LocalDateTime date_transaction;

    public void onCreate(){
        this.date_transaction=LocalDateTime.now();
    }
    
    //FK
    @ManyToOne
    @JoinColumn(name = "statut", referencedColumnName = "id_statut")
    private Statut statut;

    @ManyToOne
    @JoinColumn(name="type", referencedColumnName = "id_type")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "compte_debiteur", referencedColumnName = "id_compte")
    private Compte compte_debite;

    @ManyToOne
    @JoinColumn(name = "compte_credite", referencedColumnName = "id_compte")
    private Compte compte_credite;

    public Transaction(){
        
    }
}
