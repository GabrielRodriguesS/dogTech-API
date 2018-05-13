package main.domain.repository;

import main.domain.model.SuggestionHour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionHourRepository extends JpaRepository<SuggestionHour, Long> {

}
