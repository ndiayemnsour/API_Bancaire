package sn.bmbank.api_bancaire.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;


@Entity
@Table(name = "statut")
public class Statut {
    @Id
    private String id_statut;
    
    @Getter
    @Setter
    private String nom_statut;



    public Statut(){

    }
    
    // Générer un ID de 6 caractères basé sur UUID avant de persister l'entité
    @PrePersist
    public void generateShortUUID() {
        this.id_statut= UUID.randomUUID().toString().substring(0, 6);
    }
}
