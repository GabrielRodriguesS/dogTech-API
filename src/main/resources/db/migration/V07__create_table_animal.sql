CREATE TABLE animal (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) NOT NULL,
  `history` VARCHAR(1024) NOT NULL,
  `available` BIT NOT NULL,
  `species` enum('CANINE','FELINE') NOT NULL,
  `sex` enum('MALE', 'FEMALE') NOT NULL,
  `castred` BIT NOT NULL,
  `dewormed` BIT NOT NULL,
  `patrimonio_tombado` BIT NOT NULL,
  `care` BIT NOT NULL,
  `temperament` SET('DOCILE', 'AGGRESSIVE', 'ARISCO', 'BIPOLAR', 'NOT_SOCIABLE', 'TEMPERAMENTAL') NULL,
  `size` ENUM('SMALL', 'MEDIUM', 'BIG') NULL,
  `other_information` VARCHAR(256) NULL,
  `approximate_age` DATE NULL,
  `baia_id` BIGINT(18) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_animal_baia1_idx` (`baia_id` ASC),
  CONSTRAINT `fk_animal_baia1`
    FOREIGN KEY (`baia_id`)
    REFERENCES `dogTech`.`baia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
