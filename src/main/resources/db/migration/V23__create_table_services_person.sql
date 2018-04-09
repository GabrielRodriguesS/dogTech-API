CREATE TABLE services_person (
  `services_id` BIGINT(18) NOT NULL,
  `person_id` BIGINT(18) NOT NULL,
  `date` DATE NULL,
  `services_id1` BIGINT(18) NOT NULL,
  `person_id1` BIGINT(18) NOT NULL,
  PRIMARY KEY (`services_id`, `person_id`),
  INDEX `fk_services_person_services1_idx` (`services_id1` ASC),
  INDEX `fk_services_person_person1_idx` (`person_id1` ASC),
  CONSTRAINT `fk_services_person_services1`
    FOREIGN KEY (`services_id1`)
    REFERENCES `dogTech`.`services` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_services_person_person1`
    FOREIGN KEY (`person_id1`)
    REFERENCES `dogTech`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;