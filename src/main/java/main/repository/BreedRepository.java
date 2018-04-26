package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Breed;

public interface BreedRepository extends JpaRepository<Breed, Long> {

}
