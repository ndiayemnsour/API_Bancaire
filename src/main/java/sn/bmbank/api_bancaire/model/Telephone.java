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
    private String id_telephone;

    @PrePersist
    public void generateShortUUID(){
        this.id_telephone=UUID.randomUUID().toString().substring(0,6);
    }

    @Getter
    @Setter
    private Integer telephone_primary;

    @Getter
    @Setter
    private Integer telephone_secondary;

    @Getter
    @Setter
    private Integer telephone_personne_contacte;

     //FK
     @OneToOne
     @JoinColumn(name = "client", referencedColumnName = "id_client")
     private Client client;

     public Telephone(){

     }
}
