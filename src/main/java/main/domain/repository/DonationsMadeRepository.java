package main.domain.repository;

import main.domain.model.DonationsMade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationsMadeRepository extends JpaRepository<DonationsMade, Long> {

}
