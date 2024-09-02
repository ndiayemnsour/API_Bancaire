package sn.bmbank.api_bancaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.bmbank.api_bancaire.model.Statut;

public interface StatutRepository  extends JpaRepository <Statut, String>{
    
}
