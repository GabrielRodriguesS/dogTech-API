package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Photographer;

public interface PhotographerRepository extends JpaRepository<Photographer, Long> {

}
