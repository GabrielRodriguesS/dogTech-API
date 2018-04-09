CREATE TABLE services (
  `id` BIGINT(18) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `value` INT NULL COMMENT 'Esta tabela centraliza todas as opções de edição existentes na tela inicial do sistema que são criação de serviços, campanhas e doações de quantidas monetárias para a ong',
  `link` VARCHAR(128) NULL COMMENT 'Campo utilizado para cadatro de campanha em um site externo.',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;