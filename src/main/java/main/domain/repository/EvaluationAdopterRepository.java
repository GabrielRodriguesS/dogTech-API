package main.domain.repository;

import main.domain.model.EvaluationAdopter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationAdopterRepository extends JpaRepository<EvaluationAdopter, Long> {

}
