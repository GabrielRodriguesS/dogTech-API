package main.domain.repository;

import main.domain.model.Animal;
import main.domain.model.enums.Species;
import main.domain.repository.generic.GenericJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AnimalRepository extends GenericJpaRepository<Animal> {

    //List animals adoptable
    List<Animal> findAnimalsBySpeciesIsAndAvailableIsTrueAndPatrimonioTombadoIsFalseAndCareIsFalse(Species specie, Pageable page);

    //List all animals on administration view
    Page<Animal> findAll(Pageable page);
}
