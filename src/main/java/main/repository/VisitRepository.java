package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {

}
