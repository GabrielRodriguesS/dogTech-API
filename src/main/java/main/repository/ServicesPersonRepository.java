package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.ServicesPerson;

public interface ServicesPersonRepository extends JpaRepository<ServicesPerson, Long> {

}
