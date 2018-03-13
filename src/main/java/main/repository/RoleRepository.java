package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
