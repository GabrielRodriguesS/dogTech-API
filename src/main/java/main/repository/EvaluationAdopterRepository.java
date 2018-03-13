package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.EvaluationAdopter;

public interface EvaluationAdopterRepository extends JpaRepository<EvaluationAdopter, Long> {

}
