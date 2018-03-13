package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.PostAdoption;

public interface PostAdoptionRepository extends JpaRepository<PostAdoption, Long> {

}
