package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Services;

public interface ServicesRepository extends JpaRepository<Services, Long> {

}
