CREATE TABLE IF NOT EXISTS visit (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `date` DATETIME NULL,
  `adoption_id` BIGINT(18) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_visita_adocao1_idx` (`adoption_id` ASC),
  CONSTRAINT `fk_visita_adocao1`
    FOREIGN KEY (`adoption_id`)
    REFERENCES `dogTech`.`adoption` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;