package sn.bmbank.api_bancaire.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gestionnaire_compte")
public class GestionnaireCompte {
    @Id
    @Getter
    @Setter
    private String idGestionnaire;

    @Getter
    @Setter
    private String prenomGestionnaire;

    @Getter
    @Setter
    private String nomGestionnaire;

    @Getter
    @Setter
    private String emailGestionnaire;

    @Getter
    @Setter
    private String dateNaissanceGestionnaire;

    @Getter
    @Setter
    private LocalDateTime dateCreationGestionnaire;

    public GestionnaireCompte(){

    }

    //Generer un ID de 6 caractere base sur UUID 
    @PrePersist
    public void generateShortUUID(){
        this.idGestionnaire = UUID.randomUUID().toString().substring(0,6);
        this.dateCreationGestionnaire = LocalDateTime.now();
    }
}
