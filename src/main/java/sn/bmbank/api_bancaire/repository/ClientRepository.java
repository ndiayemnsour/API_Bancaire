package sn.bmbank.api_bancaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.bmbank.api_bancaire.model.Client;

public interface ClientRepository  extends JpaRepository <Client, String>{
    
}
