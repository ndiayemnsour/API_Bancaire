package sn.bmbank.api_bancaire.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "type")
public class Type {
    @Id
    @Getter
    @Setter
    private String idType;

    @Getter
    @Setter
    private String nomType;

    public Type(){

    }

    // Générer un ID de 6 caractères basé sur UUID avant de persister l'entité
    @PrePersist
    public void generateShortUUID() {
        this.idType= UUID.randomUUID().toString().substring(0, 6);
    }
}
