package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Story;

public interface StoryRepository extends JpaRepository<Story, Long> {

}
