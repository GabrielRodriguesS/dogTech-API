package main.repository;

import main.model.Animal;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    //@Query(value = "SELECT a FROM Animal a WHERE a.species LIKE :specie AND a.available = true")@Param("species")
    List<Animal> findBySpeciesAndAvailableIsTrue(String specie, Pageable page);
}
