CREATE TABLE story (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(2048) NULL,
  `approved` TINYINT NULL,
  `adoption_id` BIGINT(18) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_relato_adocao1_idx` (`adoption_id` ASC),
  CONSTRAINT `fk_relato_adocao1`
    FOREIGN KEY (`adoption_id`)
    REFERENCES `dogTech`.`adoption` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;