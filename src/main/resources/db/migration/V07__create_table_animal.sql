CREATE TABLE animal (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) NOT NULL,
  `history` VARCHAR(1024) NOT NULL,
  `available` ENUM('sim', 'não') NOT NULL,
  `species` ENUM('canino', 'felino') NOT NULL,
  `sex` ENUM('masculino', 'feminino') NOT NULL,
  `castred` ENUM('sim', 'não') NOT NULL,
  `dewormed` ENUM('sim', 'não') NOT NULL,
  `patromonio_tombado` ENUM('sim', 'não') NOT NULL,
  `care` ENUM('sim', 'não') NOT NULL,
  `temperament` SET('Dócil', 'Agressivo', 'Arisco', 'Bipolar', 'Não sociável', 'Temperamental') NULL,
  `size` ENUM('Pequeno', 'Medio', 'Grande') NULL,
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
