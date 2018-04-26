CREATE TABLE service_suggestion (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `service` VARCHAR(64) NOT NULL,
  `description` VARCHAR(128) NULL,
  `person_id` BIGINT(18) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_service_suggestion_person1_idx` (`person_id` ASC),
  CONSTRAINT `fk_service_suggestion_person1`
    FOREIGN KEY (`person_id`)
    REFERENCES `dogTech`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;