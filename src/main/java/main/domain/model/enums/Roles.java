package main.domain.model.enums;

import javax.transaction.Transactional;

@Transactional
public enum Roles {
    GENERAL_DIRECTOR, ADOPTION_MANAGER, ADOPTER, PUBLIC
}
