package sn.bmbank.api_bancaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.bmbank.api_bancaire.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {
    
}
