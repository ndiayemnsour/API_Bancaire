package sn.bmbank.api_bancaire.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gestionnaire_compte")
public class GestionnaireCompte {
    @Id
    private String id_gestionnaire;

    @Getter
    @Setter
    private String prenom_gestionnaire;

    @Getter
    @Setter
    private String nom_gestionnaire;

    @Getter
    @Setter
    private String email_gestionnaire;

    @Getter
    @Setter
    private String date_naissance_gestionnaire;

    @Getter
    @Setter
    private LocalDateTime date_creation_gestionnaire;

    public GestionnaireCompte(){

    }

    //Generer un ID de 6 caractere base sur UUID 
    @PrePersist
    public void generateShortUUID(){
        this.id_gestionnaire = UUID.randomUUID().toString().substring(0,6);
    }

    // Initialiser la date de création avant de persister l'entité
    
    protected void onCreate() {
        this.date_creation_gestionnaire = LocalDateTime.now();
    }

    //relation many to one avec statut 
    @ManyToOne
    @JoinColumn(name = "statut", referencedColumnName="id_statut")

    @Getter
    @Setter
    private Statut statut;
}
