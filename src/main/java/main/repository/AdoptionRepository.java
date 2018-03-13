package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Adoption;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {

}
