package main.domain.model.enums;

import javax.transaction.Transactional;

@Transactional
public enum Complement {
    HOME, APARTMENT, COMMERCIAL, OTHER
}
