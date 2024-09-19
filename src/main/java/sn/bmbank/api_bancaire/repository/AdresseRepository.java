package sn.bmbank.api_bancaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.bmbank.api_bancaire.model.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, String>{
    
}
