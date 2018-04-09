package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.ListVaccinesAnimal;

public interface ListVaccinesAnimalRepository extends JpaRepository<ListVaccinesAnimal, Long> {

}
