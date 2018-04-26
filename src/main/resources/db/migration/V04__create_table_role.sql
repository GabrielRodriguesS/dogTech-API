CREATE TABLE role (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `name` ENUM('Diretor Geral', 'Gestor de Adoção', 'Adotante') NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;