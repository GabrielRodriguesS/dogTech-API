package main.domain.repository;

import main.domain.model.Configurations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationsRepository extends JpaRepository<Configurations, Long> {

}
