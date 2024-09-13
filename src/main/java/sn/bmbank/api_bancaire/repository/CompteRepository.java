package sn.bmbank.api_bancaire.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sn.bmbank.api_bancaire.model.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, String> {

    //recuperer le solde du compte par son numero_compte
   // @Query("SELECT c FROM Compte c WHERE c.numero_compte = :numero_compte")
    //Optional<Compte> findByNumero_compte(@Param("numero_compte") Integer numero_compte);



}
