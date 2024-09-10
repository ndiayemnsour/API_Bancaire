package sn.bmbank.api_bancaire.model;

import lombok.*;
import java.time.*;

@Data
@Getter
@Setter
public class CompteDTO {

        private Integer numeroCompte;
        private Float solde;
        private String nomType;
        private LocalDate dateCreationCompte;
        private String nomStatut;
        private String nomClient;
        private String prenomClient;
        private String nomGestionnaire;
        private String prenomGestionnaire;
    
        // Constructeurs, getters, setters
        public CompteDTO(Integer numeroCompte, Float solde, String nomType, LocalDate dateCreationCompte,String nomStatut, 
                                String nomClient, String prenomClient, 
                                String nomGestionnaire, String prenomGestionnaire) {
            this.numeroCompte = numeroCompte;
            this.solde = solde;
            this.nomType = nomType;
            this.dateCreationCompte=dateCreationCompte;
            this.nomStatut = nomStatut;
            this.nomClient = nomClient;
            this.prenomClient = prenomClient;
            this.nomGestionnaire = nomGestionnaire;
            this.prenomGestionnaire = prenomGestionnaire;
        }
    
        // Getters and Setters
    }
    
