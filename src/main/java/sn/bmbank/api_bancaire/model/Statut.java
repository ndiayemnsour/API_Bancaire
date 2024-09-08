package sn.bmbank.api_bancaire.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.*;
import java.util.UUID;


@Entity
@Table(name = "statut")
public class Statut {
    @Id
    @Getter
    @Setter
    private String id_statut;
    
    @Setter
    private String nom_statut;



    public Statut(){

    }
    public String getNom_statut() {
        return nom_statut;
    }
    // Générer un ID de 6 caractères basé sur UUID avant de persister l'entité
    @PrePersist
    public void generateShortUUID() {
        this.id_statut= UUID.randomUUID().toString().substring(0, 6);
    }
}
