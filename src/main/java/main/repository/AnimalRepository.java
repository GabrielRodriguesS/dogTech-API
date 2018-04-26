package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
