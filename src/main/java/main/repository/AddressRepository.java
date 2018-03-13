package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
