package main.domain.repository;

import main.domain.model.Role;
import main.domain.model.enums.Roles;
import main.domain.repository.generic.GenericJpaRepository;

public interface RoleRepository extends GenericJpaRepository<Role> {

    Role findRoleByName(Roles role);
}
