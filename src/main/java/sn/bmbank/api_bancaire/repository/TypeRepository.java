package sn.bmbank.api_bancaire.repository;


import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import sn.bmbank.api_bancaire.model.Type;

public interface TypeRepository extends JpaRepository <Type, String>{
    @Query("SELECT t.nomType FROM Type t")
    List<String> findAllNomTypes(); // Retourne une liste de noms de types
}
