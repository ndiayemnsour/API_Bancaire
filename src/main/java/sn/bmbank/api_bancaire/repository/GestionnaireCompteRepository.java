package sn.bmbank.api_bancaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.bmbank.api_bancaire.model.GestionnaireCompte;

public interface GestionnaireCompteRepository extends JpaRepository<GestionnaireCompte, String>{
    
}
