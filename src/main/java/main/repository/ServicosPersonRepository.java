package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.ServicosPerson;

public interface ServicosPersonRepository extends JpaRepository<ServicosPerson, Long> {

}
