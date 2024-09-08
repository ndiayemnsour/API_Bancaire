package sn.bmbank.api_bancaire.repository;

import java.util.*;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sn.bmbank.api_bancaire.model.Compte;


public interface CompteRepository extends JpaRepository<Compte, String> {
    Page<Compte> findAll(Pageable pageable);

    @Query("SELECT c FROM Compte c WHERE c.id_compte = :id_compte")
    Optional<Compte> findById_compte(@Param("id_compte") String id_compte);

}
