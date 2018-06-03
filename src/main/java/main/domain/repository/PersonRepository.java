package main.domain.repository;

import main.domain.model.Person;
import main.domain.repository.generic.GenericJpaRepository;

import java.util.Optional;

public interface PersonRepository extends GenericJpaRepository<Person> {
    Optional<Person> findOneByEmailIgnoreCase(String email);

    Person findByToken(String token);

}
