package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Donations;

public interface DonationsRepository extends JpaRepository<Donations, Long> {

}
