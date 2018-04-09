CREATE TABLE person (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) NOT NULL,
  `email` VARCHAR(128) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `voluntary` TINYINT NOT NULL,
  `token` VARCHAR(32) NULL,
  `date_token` DATETIME NULL,
  `default_password` TINYINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC))
ENGINE = InnoDB;

