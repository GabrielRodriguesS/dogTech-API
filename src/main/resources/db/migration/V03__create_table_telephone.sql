CREATE TABLE telephone (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(15) NULL,
  `whatsapp` TINYINT NULL COMMENT 'É um numero do whatsapp ou nao?',
  `identifier` VARCHAR(64) NULL COMMENT 'Identificador do telefone, exemplo \"telefone de casa\", \"telefone do comercio\"',
  `person_id` BIGINT(18) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_telefone_pessoa1_idx` (`person_id` ASC),
  CONSTRAINT `fk_telefone_pessoa1`
    FOREIGN KEY (`person_id`)
    REFERENCES `dogTech`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;