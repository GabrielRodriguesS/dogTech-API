package main.domain.repository;

import main.domain.model.Animal;
import main.domain.model.enums.Species;
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
