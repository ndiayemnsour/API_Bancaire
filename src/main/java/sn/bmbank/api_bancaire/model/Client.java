package sn.bmbank.api_bancaire.model;

import java.time.*;
import java.util.UUID;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @Getter
    @Setter
    private String id_client;

    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private String prenom;

    @Getter
    @Setter
    private LocalDate date_naissance;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private LocalDateTime date_creation;
    
    public Client(){

    }

    // Générer un ID de 6 caractères basé sur UUID avant de persister l'entité
    @PrePersist
    public void generateShortUUID() {
        this.id_client= UUID.randomUUID().toString().substring(0, 6);
        this.date_creation = LocalDateTime.now();
    }
}
