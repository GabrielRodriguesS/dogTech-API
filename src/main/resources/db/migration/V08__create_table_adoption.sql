CREATE TABLE adoption (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `date_interest` DATE NULL,
  `date_adoption` DATE NULL,
  `status` ENUM('Aguardando', 'Adotado', 'Animal devolvido', 'Desistencia', 'Aguardando visita', 'Reprovada', 'Revogada') NULL DEFAULT 'Aguardando',
  `adopter` BIGINT(18) NOT NULL,
  `adoption_manager` BIGINT(18) NOT NULL,
  `animal_id` BIGINT(18) NOT NULL,
  `animal_id1` BIGINT(18) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_adocao_pessoa1_idx` (`adopter` ASC),
  INDEX `fk_adocao_pessoa2_idx` (`adoption_manager` ASC),
  INDEX `fk_adoption_animal1_idx` (`animal_id1` ASC),
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
  CONSTRAINT `fk_adoption_animal1`
    FOREIGN KEY (`animal_id1`)
    REFERENCES `dogTech`.`animal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;