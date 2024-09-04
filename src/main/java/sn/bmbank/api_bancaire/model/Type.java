package sn.bmbank.api_bancaire.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "type")
public class Type {
    @Id
    private String id_type;

    @Getter
    @Setter
    private String nom_type;

    public Type(){

    }

    // Générer un ID de 6 caractères basé sur UUID avant de persister l'entité
    @PrePersist
    public void generateShortUUID() {
        this.id_type= UUID.randomUUID().toString().substring(0, 6);
    }
}
