package sn.bmbank.api_bancaire.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import sn.bmbank.api_bancaire.model.Type;

public interface TypeRepository extends JpaRepository <Type, String>{
    
}
