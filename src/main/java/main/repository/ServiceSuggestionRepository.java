package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.ServiceSuggestion;

public interface ServiceSuggestionRepository extends JpaRepository<ServiceSuggestion, Long> {

}
