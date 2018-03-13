package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.ListaVacinasAnimal;

public interface ListaVacinasAnimalRepository extends JpaRepository<ListaVacinasAnimal, Long> {

}
