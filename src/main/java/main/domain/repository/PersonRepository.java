package main.domain.repository;

import main.domain.model.Person;
import main.domain.repository.generic.GenericJpaRepository;

import java.util.Optional;

public interface PersonRepository extends GenericJpaRepository<Person> {
    Person findByToken(String token);

    Optional<Person> findOneByEmailIgnoreCase(String email);

}
