package main.domain.repository;

import main.domain.dto.AdoptionDTO;
import main.domain.stateMachine.stateMachineEnums.States;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdoptionDTORepository extends JpaRepository<AdoptionDTO, Long> {
    List<AdoptionDTO> findAdoptionDTOByStatusIsAndPostAdoptionListIsNull(States states);
}
