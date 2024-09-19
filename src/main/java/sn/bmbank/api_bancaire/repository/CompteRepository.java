package sn.bmbank.api_bancaire.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.bmbank.api_bancaire.model.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, String> {

    Optional<Compte> findByNumeroCompte(Integer numeroCompte);

}
