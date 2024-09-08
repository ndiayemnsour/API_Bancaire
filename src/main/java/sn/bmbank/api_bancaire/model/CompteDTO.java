package sn.bmbank.api_bancaire.model;

import lombok.*;
import java.time.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompteDTO {

    private String id_compte;
    private Integer numero_compte;
    private Float solde;
    private LocalDate date_ouverture;
    private LocalDate date_fermature;
    private String devise;
    private String nom_statut;
    private String nom_type;
    private String nom_client;
    private String prenom_client;
    private String nom_gestionnaire;
    private String prenom_gestionnaire;

    //Getter et Setter

    public String getId_compte() {
        return id_compte;
    }

    public void setId_compte(String id_compte) {
        this.id_compte = id_compte;
    }

    public Integer getNumero_compte() {
        return numero_compte;
    }

    public void setNumero_compte(Integer numero_compte) {
        this.numero_compte = numero_compte;
    }

    public Float getSolde() {
        return solde;
    }

    public void setSolde(Float solde) {
        this.solde = solde;
    }

    public LocalDate getDate_ouverture() {
        return date_ouverture;
    }

    public void setDate_ouverture(LocalDate date_ouverture) {
        this.date_ouverture = date_ouverture;
    }

    public LocalDate getDate_fermature() {
        return date_fermature;
    }

    public void setDate_fermature(LocalDate date_fermature) {
        this.date_fermature = date_fermature;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getNom_statut() {
        return nom_statut;
    }

    public void setNom_statut(String nom_statut) {
        this.nom_statut = nom_statut;
    }

    public String getNom_type() {
        return nom_type;
    }

    public void setNom_type(String nom_type) {
        this.nom_type = nom_type;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getNom_gestionnaire() {
        return nom_gestionnaire;
    }

    public void setNom_gestionnaire(String nom_gestionnaire) {
        this.nom_gestionnaire = nom_gestionnaire;
    }

    
}
