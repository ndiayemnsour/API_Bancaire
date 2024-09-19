package sn.bmbank.api_bancaire.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "adresse")
public class Adresse {
    @Id
    @Getter
    @Setter
    private String idAdresse;

    @PrePersist
    public void generateShortUUID() {
        this.idAdresse= UUID.randomUUID().toString().substring(0, 6);
    }

    @Getter
    @Setter
    private String pays;

    @Getter
    @Setter
    private String ville;

    @Getter
    @Setter
    private String quartier;

    @Getter
    @Setter
    private String rue;

    @Getter
    @Setter
    private Integer codePostal;

    //FK
    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "client", referencedColumnName = "idClient")
    private Client client;

    public Adresse(){
        
    }
}
