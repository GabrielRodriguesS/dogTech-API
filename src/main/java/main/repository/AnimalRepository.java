package main.repository;

import main.model.Animal;
import main.model.enums.Species;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    //List animals adoptable
    List<Animal> findAnimalsBySpeciesIsAndAvailableIsTrueAndPatrimonioTombadoIsFalseAndCareIsFalse(Species specie, Pageable page);

    //List all animals on administration view
    Page<Animal> findAll(Pageable page);
}
