package main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	public Optional<Person> findOneByEmailIgnoreCase(String email);

	public Person findByToken(String token);
}
