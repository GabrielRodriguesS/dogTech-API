package main.domain.repository;

import main.domain.model.ListVaccinesAnimal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListVaccinesAnimalRepository extends JpaRepository<ListVaccinesAnimal, Long> {

}
