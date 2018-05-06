CREATE TABLE address (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(128) NULL,
  `city` VARCHAR(128) NULL,
  `state` VARCHAR(33) NULL,
  `zip_code` VARCHAR(9) NULL,
  `number` VARCHAR(16) NULL,
  `complement` ENUM('home', 'apartment', 'commercial', 'other') NULL,
  `person_id` BIGINT(18) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_endereco_pessoa_idx` (`person_id` ASC),
  CONSTRAINT `fk_endereco_pessoa`
    FOREIGN KEY (`person_id`)
    REFERENCES `dogTech`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;