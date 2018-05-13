package main.domain.repository;

import main.domain.model.Donations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationsRepository extends JpaRepository<Donations, Long> {

}
