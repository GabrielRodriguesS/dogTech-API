CREATE TABLE IF NOT EXISTS post_adoption (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `feedback` VARCHAR(512) NULL,
  `post_adoption_id` BIGINT(18) NULL,
  `adoption_id` BIGINT(18) NOT NULL,
  `author` BIGINT(18) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pos_adocao_pos_adocao1_idx` (`post_adoption_id` ASC),
  INDEX `fk_pos_adocao_adocao1_idx` (`adoption_id` ASC),
  CONSTRAINT `fk_pos_adocao_pos_adocao1`
    FOREIGN KEY (`post_adoption_id`)
    REFERENCES `dogTech`.`post_adoption` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pos_adocao_adocao1`
    FOREIGN KEY (`adoption_id`)
    REFERENCES `dogTech`.`adoption` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;