package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.SuggestionHour;

public interface SuggestionHourRepository extends JpaRepository<SuggestionHour, Long> {

}
