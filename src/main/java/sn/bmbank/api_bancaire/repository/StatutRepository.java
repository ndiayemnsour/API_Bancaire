package sn.bmbank.api_bancaire.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sn.bmbank.api_bancaire.model.Statut;

public interface StatutRepository  extends JpaRepository <Statut, String>{
    @Query("SELECT t.nomStatut FROM Statut t")
    List<String> findAllNomStatut();
}
