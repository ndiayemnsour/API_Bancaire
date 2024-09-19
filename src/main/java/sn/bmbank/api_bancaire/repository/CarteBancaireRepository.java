package sn.bmbank.api_bancaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.bmbank.api_bancaire.model.CarteBancaire;

public interface CarteBancaireRepository extends JpaRepository<CarteBancaire,String>{
    
}
