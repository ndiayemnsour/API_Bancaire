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
    private String id_compte;

    @Getter
    @Setter
    private Integer numero_compte;

    @Getter
    @Setter
    private Float solde;

    @Getter
    @Setter
    private LocalDate date_ouverture;

    @Getter
    @Setter
    private LocalDate date_fermature;


    @Getter
    @Setter
    private String devise;


    @PrePersist
    public void generateShortUUID(){
        this.id_compte=UUID.randomUUID().toString().substring(0,6);
        this.date_ouverture=LocalDate.now();
    }

    //Clés etrangeres
    @ManyToOne
    @JoinColumn(name = "statut", referencedColumnName = "id_statut")

    @Getter
    @Setter
    private Statut statut;

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "id_type")

    @Getter
    @Setter
    private Type type;

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "id_client")

    @Getter
    @Setter
    private Client client;

    @ManyToOne
    @JoinColumn(name = "gestionnaire_compte", referencedColumnName = "id_gestionnaire")

    @Getter
    @Setter
    private GestionnaireCompte gestionnaire_compte;
    
   public Compte(){
    
   }
}
