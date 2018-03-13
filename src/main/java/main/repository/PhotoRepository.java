package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

}
