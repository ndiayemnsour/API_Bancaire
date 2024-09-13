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
    private String idTransaction;

    @PrePersist
    public void generateShortUUID(){
        this.idTransaction=UUID.randomUUID().toString().substring(0,6);
    }
    
    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Float montant;

    @Getter
    @Setter
    private LocalDateTime dateTransaction;

    public void onCreate(){
        this.dateTransaction=LocalDateTime.now();
    }
    
    //FK
    @ManyToOne
    @Getter
    @JoinColumn(name = "statut", referencedColumnName = "idStatut")
    private Statut statut;

    @ManyToOne
    @Getter
    @JoinColumn(name="type", referencedColumnName = "idType")
    private Type type;

    @ManyToOne
    @Getter
    @JoinColumn(name = "compteDebiteur", referencedColumnName = "idCompte")
    private Compte compteDebite;

    @ManyToOne
    @Getter
    @JoinColumn(name = "compteCredite", referencedColumnName = "idCompte")
    private Compte compteCredite;

    public Transaction(){
        
    }
}
