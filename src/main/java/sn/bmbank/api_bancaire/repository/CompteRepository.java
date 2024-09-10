package sn.bmbank.api_bancaire.repository;

import java.util.*;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sn.bmbank.api_bancaire.model.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, String> {
    Page<Compte> findAll(Pageable pageable);

    //recuperer le solde du compte par son ID
    // @Query("SELECT c FROM Compte c WHERE c.id_compte = :id_compte")
    // Optional<Compte> findById_compte(@Param("id_compte") String id_compte);

    //recuperer le solde du compte par son numero_compte
    @Query("SELECT c FROM Compte c WHERE c.numero_compte = :numero_compte")
    Optional<Compte> findByNumero_compte(@Param("numero_compte") Integer numero_compte);

    //Recuperer le compte
    // @Query("SELECT new com.example.dto.CompteDTO(c.numero_compte, c.solde, t.nom_type,t.date_creation_compte, s.nom_statut, cl.nom, cl.prenom, g.nom, g.prenom) " +
    //    "FROM Compte c " +
    //    "JOIN c.typeCompte t " +
    //    "JOIN c.dateCreationCompte d " +
    //    "JOIN c.statut s " +
    //    "JOIN c.client cl " +
    //    "JOIN c.gestionnaire g " +
    //    "WHERE c.numero_compte = :numero_compte")
    // Optional<CompteDTO> findById_compte(@Param("numero_compte") Integer numero_compte);


}
