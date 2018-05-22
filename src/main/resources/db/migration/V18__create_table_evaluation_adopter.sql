CREATE TABLE IF NOT EXISTS evaluation_adopter (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `stars` FLOAT NULL,
  `adoption_id` BIGINT(18) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_avaliacao_adotante_adocao1_idx` (`adoption_id` ASC),
  CONSTRAINT `fk_avaliacao_adotante_adocao1`
    FOREIGN KEY (`adoption_id`)
    REFERENCES `dogTech`.`adoption` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;