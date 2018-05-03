package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Adoption;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {

    @Modifying(clearAutomatically = true)
    @Query("update Adoption adoption set adoption.status = :state where adoption.id = :id")
    Adoption updateState(@Param("id") Long id, @Param("state") String state);
}
