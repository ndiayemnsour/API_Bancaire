package sn.bmbank.api_bancaire.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "telephone")
public class Telephone {
    @Id
    @Getter
    @Setter
    private String idTelephone;

    @PrePersist
    public void generateShortUUID(){
        this.idTelephone=UUID.randomUUID().toString().substring(0,6);
    }

    @Getter
    @Setter
    private Integer telephonePrimary;

    @Getter
    @Setter
    private Integer telephoneSecondary;

    @Getter
    @Setter
    private Integer telephonePersonneContacte;

     //FK
     @OneToOne
     @JoinColumn(name = "client", referencedColumnName = "idClient")
     private Client client;

     public Telephone(){

     }
}
