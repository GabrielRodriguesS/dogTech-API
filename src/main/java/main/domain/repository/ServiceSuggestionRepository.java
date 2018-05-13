package main.domain.repository;

import main.domain.model.ServiceSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceSuggestionRepository extends JpaRepository<ServiceSuggestion, Long> {

}
