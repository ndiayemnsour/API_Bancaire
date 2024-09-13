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
    private String idCarte;

    @PrePersist
    public void generateShortUUID() {
        this.idCarte= UUID.randomUUID().toString().substring(0, 6);
    }

    @Getter
    @Setter
    private Integer numeroCarte;

    @Getter
    @Setter
    private Integer cvv;

    @Getter
    @Setter
    private LocalDate dateExpiration;

    //FK
    @ManyToOne
    @JoinColumn(name = "statut", referencedColumnName = "idStatut")
    private Statut statut;

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "idType")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "compte", referencedColumnName = "idCompte")
    private Compte compte;

    public CarteBancaire(){
        
    }
}
