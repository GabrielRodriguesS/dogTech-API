package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
