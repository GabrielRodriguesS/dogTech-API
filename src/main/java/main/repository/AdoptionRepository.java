package main.repository;

import main.dto.AdoptionDTO;
import main.model.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {

    @Modifying(clearAutomatically = true)
    @Query("update Adoption adoption set adoption.status = :state where adoption.id = :id")
    Adoption updateState(@Param("id") Long id, @Param("state") String state);

    @Query("select new main.dto.AdoptionDTO(" +
            "animal.id, animal.name, a.dateAdoption, a.dateInterest, a.status, adopter.name, manager.name) " +
            "from Adoption a " +
            "join a.adopter adopter " +
            "join a.animalId animal " +
            "join a.adoptionManager manager")
    List<AdoptionDTO> findAllAdoptionDTO();
}
