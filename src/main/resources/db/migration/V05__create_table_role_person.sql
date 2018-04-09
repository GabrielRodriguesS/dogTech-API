CREATE TABLE role_person (
  `person_id` BIGINT(18) NOT NULL,
  `role_id` BIGINT(18) NOT NULL,
  PRIMARY KEY (`person_id`, `role_id`),
  INDEX `fk_pessoa_has_cargos_cargos1_idx` (`role_id` ASC),
  INDEX `fk_pessoa_has_cargos_pessoa1_idx` (`person_id` ASC),
  CONSTRAINT `fk_pessoa_has_cargos_pessoa1`
    FOREIGN KEY (`person_id`)
    REFERENCES `dogTech`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pessoa_has_cargos_cargos1`
    FOREIGN KEY (`role_id`)
    REFERENCES `dogTech`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;