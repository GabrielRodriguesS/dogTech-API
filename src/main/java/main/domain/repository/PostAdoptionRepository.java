package main.domain.repository;

import main.domain.model.PostAdoption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostAdoptionRepository extends JpaRepository<PostAdoption, Long> {

}
