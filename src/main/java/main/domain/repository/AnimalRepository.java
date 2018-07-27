package main.domain.repository;

import main.domain.dto.AnimalDTO;
import main.domain.model.Animal;
import main.domain.model.enums.Species;
import main.domain.repository.generic.GenericJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends GenericJpaRepository<Animal> {

    //List animals adoptable
    @Query("SELECT new main.domain.dto.AnimalDTO(a) from Animal a " +
            "where a.species = :specie and a.available = true " +
            "and a.patrimonioTombado = false and a.care = false")
    List<AnimalDTO> findAnimalsBySpeciesIsAndAvailableIsTrueAndPatrimonioTombadoIsFalseAndCareIsFalse(@Param("specie") Species specie);

    //List all animals on administration view
    Page<Animal> findAll(Pageable page);
}
