CREATE TABLE photo (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `real_path` VARCHAR(128) NULL,
  `path_thumbnail` VARCHAR(128) NULL,
  `photo_link` VARCHAR(2048) NULL,
  `person_id` BIGINT(18) NULL,
  `adoption_id` BIGINT(18) NULL,
  `post_adoption_id` BIGINT(18) NULL,
  `story_id` BIGINT(18) NULL,
  `animal_id` BIGINT(18) NULL,
  `photographer_id` BIGINT(18) NULL,
  `services_person_services_id` BIGINT(18) NULL,
  `services_person_person_id` BIGINT(18) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_photo_person1_idx` (`person_id` ASC),
  INDEX `fk_photo_adoption1_idx` (`adoption_id` ASC),
  INDEX `fk_photo_post_adoption1_idx` (`post_adoption_id` ASC),
  INDEX `fk_photo_story1_idx` (`story_id` ASC),
  INDEX `fk_photo_animal1_idx` (`animal_id` ASC),
  INDEX `fk_photo_photographer1_idx` (`photographer_id` ASC),
  INDEX `fk_photo_services_person1_idx` (`services_person_services_id` ASC, `services_person_person_id` ASC),
  CONSTRAINT `fk_photo_person1`
    FOREIGN KEY (`person_id`)
    REFERENCES `dogTech`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_photo_adoption1`
    FOREIGN KEY (`adoption_id`)
    REFERENCES `dogTech`.`adoption` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_photo_post_adoption1`
    FOREIGN KEY (`post_adoption_id`)
    REFERENCES `dogTech`.`post_adoption` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_photo_story1`
    FOREIGN KEY (`story_id`)
    REFERENCES `dogTech`.`story` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_photo_animal1`
    FOREIGN KEY (`animal_id`)
    REFERENCES `dogTech`.`animal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_photo_photographer1`
    FOREIGN KEY (`photographer_id`)
    REFERENCES `dogTech`.`photographer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_photo_services_person1`
    FOREIGN KEY (`services_person_services_id` , `services_person_person_id`)
    REFERENCES `dogTech`.`services_person` (`services_id` , `person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;