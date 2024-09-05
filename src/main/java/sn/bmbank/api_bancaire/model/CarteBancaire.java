package sn.bmbank.api_bancaire.model;

import java.time.*;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "carte_bancaire")
public class CarteBancaire {
    @Id
    @Getter
    @Setter
    private String id_carte;

    @PrePersist
    public void generateShortUUID() {
        this.id_carte= UUID.randomUUID().toString().substring(0, 6);
    }

    @Getter
    @Setter
    private Integer numero_carte;

    @Getter
    @Setter
    private Integer cvv;

    @Getter
    @Setter
    private LocalDate date_expiration;

    //FK
    @ManyToOne
    @JoinColumn(name = "statut", referencedColumnName = "id_statut")
    private Statut statut;

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "id_type")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "compte", referencedColumnName = "id_compte")
    private Compte compte;

    public CarteBancaire(){
        
    }
}
