CREATE TABLE suggestion_hour (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `visit_id` BIGINT(18) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_suggestion_hour_visit1_idx` (`visit_id` ASC),
  CONSTRAINT `fk_suggestion_hour_visit1`
    FOREIGN KEY (`visit_id`)
    REFERENCES `dogTech`.`visit` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;