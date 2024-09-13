package sn.bmbank.api_bancaire.model;

import java.time.*;
import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "compte")
public class Compte {
    @Id
    @Getter
    @Setter
    private String idCompte;

    @Getter
    @Setter
    private Integer numeroCompte;

    @Getter
    @Setter
    private Float solde;

    @Getter
    @Setter
    private LocalDate dateOuverture;

    @Getter
    @Setter
    private LocalDate dateFermature;


    @Getter
    @Setter
    private String devise;


    @PrePersist
    public void generateShortUUID(){
        this.idCompte=UUID.randomUUID().toString().substring(0,6);
        this.dateOuverture=LocalDate.now();
    }

    //Clés etrangeres
    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name = "statut", referencedColumnName = "idStatut")
    private Statut statut;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name = "type", referencedColumnName = "idType")
    private Type type;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name = "client", referencedColumnName = "idClient")
    private Client client;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name = "gestionnaireCompte", referencedColumnName = "idGestionnaire")
    private GestionnaireCompte gestionnaire;

   public Compte(){
    
   }
}
