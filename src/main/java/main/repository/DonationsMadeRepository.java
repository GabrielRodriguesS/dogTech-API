package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.DonationsMade;

public interface DonationsMadeRepository extends JpaRepository<DonationsMade, Long> {

}
