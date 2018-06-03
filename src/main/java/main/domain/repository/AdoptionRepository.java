package main.domain.repository;

import main.domain.dto.AdoptionDTO;
import main.domain.model.Adoption;
import main.domain.model.Animal;
import main.domain.repository.generic.GenericJpaRepository;
import main.domain.stateMachine.stateMachineEnums.States;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdoptionRepository extends GenericJpaRepository<Adoption> {

    List<Adoption> findByAnimalIdAndStatusEquals(Animal animal, States states);

    @Modifying(clearAutomatically = true)
    @Query("update Adoption adoption set adoption.status = :state where adoption.id = :id")
    Adoption updateState(@Param("id") Long id, @Param("state") States state);

    @Query("select new main.domain.dto.AdoptionDTO(a) from Adoption a " +
            "join a.adopter adopter " +
            "join a.animal animal " +
            "join a.manager manager")
    List<AdoptionDTO> findAllAdoptionDTO();

    List<Adoption> findAdoptionsByStatusIsAndPostAdoptionListIsNull(States states);
}
