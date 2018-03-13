package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

}
