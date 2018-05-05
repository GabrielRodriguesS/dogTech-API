CREATE TABLE adoption (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `date_interest` DATE NULL,
  `date_adoption` DATE NULL,
  `status` ENUM('WAITING', 'REJECTED', 'WAITING_VISIT', 'DESISTING', 'ADOPTED', 'RETURNED', 'REVOKED') NULL,
  `adopter` BIGINT(18) NOT NULL,
  `adoption_manager` BIGINT(18) NOT NULL,
  `animal_id` BIGINT(18) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_adocao_pessoa1_idx` (`adopter` ASC),
  INDEX `fk_adocao_pessoa2_idx` (`adoption_manager` ASC),
  INDEX `fk_adoption_animal_idx` (`animal_id` ASC),
  CONSTRAINT `fk_adocao_pessoa1`
    FOREIGN KEY (`adopter`)
    REFERENCES `dogTech`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_adocao_pessoa2`
    FOREIGN KEY (`adoption_manager`)
    REFERENCES `dogTech`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_adoption_animal`
    FOREIGN KEY (`animal_id`)
    REFERENCES `dogTech`.`animal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;