CREATE TABLE role (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `name` ENUM('general director', 'adoption manager', 'adopter') NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;