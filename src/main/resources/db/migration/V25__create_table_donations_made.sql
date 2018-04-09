CREATE TABLE donations_made (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `origin` VARCHAR(128) NULL,
  `photo_id` BIGINT(18) NOT NULL,
  `donations_id` BIGINT(18) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_donations_made_photo1_idx` (`photo_id` ASC),
  INDEX `fk_donations_made_donations1_idx` (`donations_id` ASC),
  CONSTRAINT `fk_donations_made_photo1`
    FOREIGN KEY (`photo_id`)
    REFERENCES `dogTech`.`photo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_donations_made_donations1`
    FOREIGN KEY (`donations_id`)
    REFERENCES `dogTech`.`donations` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;