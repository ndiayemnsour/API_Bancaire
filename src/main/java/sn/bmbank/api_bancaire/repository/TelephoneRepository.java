package sn.bmbank.api_bancaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.bmbank.api_bancaire.model.Telephone;

public interface TelephoneRepository extends JpaRepository<Telephone, String> {
    
}
