package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Configurations;

public interface ConfigurationsRepository extends JpaRepository<Configurations, Long> {

}
