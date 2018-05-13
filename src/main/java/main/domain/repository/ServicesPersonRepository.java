package main.domain.repository;

import main.domain.model.ServicesPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesPersonRepository extends JpaRepository<ServicesPerson, Long> {

}
