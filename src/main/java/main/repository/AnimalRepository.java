package main.repository;

import main.model.Animal;
import main.model.enums.Species;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findAnimalsBySpeciesIsAndAvailableIsTrue(Species specie, Pageable page);
}
