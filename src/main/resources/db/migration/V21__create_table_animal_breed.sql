CREATE TABLE IF NOT EXISTS animal_breed (
  `animal_id` BIGINT(18) NOT NULL,
  `breed_id` BIGINT(18) NOT NULL,
  PRIMARY KEY (`animal_id`, `breed_id`),
  INDEX `fk_animal_has_breed_breed1_idx` (`breed_id` ASC),
  INDEX `fk_animal_has_breed_animal1_idx` (`animal_id` ASC),
  CONSTRAINT `fk_animal_has_breed_animal1`
    FOREIGN KEY (`animal_id`)
    REFERENCES `dogTech`.`animal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_has_breed_breed1`
    FOREIGN KEY (`breed_id`)
    REFERENCES `dogTech`.`breed` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;