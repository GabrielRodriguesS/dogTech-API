package main.repository;

import main.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findOneByEmailIgnoreCase(String email);

    Person findByToken(String token);

}
