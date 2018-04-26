package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Telephone;

public interface TelephoneRepository extends JpaRepository<Telephone, Long> {

}
