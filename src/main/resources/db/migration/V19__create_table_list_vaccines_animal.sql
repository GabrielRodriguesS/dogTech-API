CREATE TABLE list_vaccines_animal (
  `animal_id` BIGINT(18) NOT NULL,
  `vaccine_id` BIGINT(18) NOT NULL,
  `application_date` DATE NULL,
  PRIMARY KEY (`animal_id`, `vaccine_id`),
  INDEX `fk_animal_has_vaccine_vaccine1_idx` (`vaccine_id` ASC),
  INDEX `fk_animal_has_vaccine_animal1_idx` (`animal_id` ASC),
  CONSTRAINT `fk_animal_has_vaccine_animal1`
    FOREIGN KEY (`animal_id`)
    REFERENCES `dogTech`.`animal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_has_vaccine_vaccine1`
    FOREIGN KEY (`vaccine_id`)
    REFERENCES `dogTech`.`vaccine` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;