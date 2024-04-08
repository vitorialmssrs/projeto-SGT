-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `mydb` ;

CREATE DATABASE IF NOT EXISTS `mydb` ;

USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`hospedagens`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`hospedagens` ;

CREATE TABLE IF NOT EXISTS `mydb`.`hospedagens` (
  `num_quarto` INT(3) NOT NULL,
  `checkin` DATETIME NOT NULL,
  `checkout` DATETIME NOT NULL,
  PRIMARY KEY (`num_quarto`));


-- -----------------------------------------------------
-- Table `mydb`.`clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`clientes` ;

CREATE TABLE IF NOT EXISTS `mydb`.`clientes` (
  `id_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `num_identificacao` INT(11) NOT NULL,
  `primeiro_nome` VARCHAR(100) NOT NULL,
  `sobrenome` VARCHAR(100) NOT NULL,
  `data_de_nascimento` DATE NOT NULL,
  `telefone` INT(11) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `hospedagens_num_quarto` INT(3) NOT NULL,
  PRIMARY KEY (`id_cliente`, `hospedagens_num_quarto`),
  CONSTRAINT `fk_clientes_hospedagens1`
    FOREIGN KEY (`hospedagens_num_quarto`)
    REFERENCES `mydb`.`hospedagens` (`num_quarto`)   );


-- -----------------------------------------------------
-- Table `mydb`.`espacos_hotel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`espacos_hotel` ;

CREATE TABLE IF NOT EXISTS `mydb`.`espacos_hotel` (
  `id_espacos` INT(7) NOT NULL,
  `nome_espaco` VARCHAR(100) NOT NULL,
  `dia_semana_abertura` DATE NOT NULL,
  `dia_semana_fechamento` DATE NOT NULL,
  `horario_abertura` TIME NOT NULL,
  `horario_fechamento` TIME NOT NULL,
  `capacidade` INT(3) NOT NULL,
  PRIMARY KEY (`id_espacos`));


-- -----------------------------------------------------
-- Table `mydb`.`gerenciamento_acesso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`gerenciamento_acesso` ;

CREATE TABLE IF NOT EXISTS `mydb`.`gerenciamento_acesso` (
  `login_cliente_id_login_cliente` INT(7) NOT NULL,
  `login_cliente_clientes_id_clientes` INT(7) NOT NULL,
  PRIMARY KEY (`login_cliente_id_login_cliente`, `login_cliente_clientes_id_clientes`));


-- -----------------------------------------------------
-- Table `mydb`.`funcionarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`funcionarios` ;

CREATE TABLE IF NOT EXISTS `mydb`.`funcionarios` (
  `id_funcionario` INT(7) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `num_identificacao` INT(7) NOT NULL,
  `nome_completo` VARCHAR(100) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `telefone` INT(11) NOT NULL,
  `cep` INT(8) NOT NULL,
  `num_casa` INT(4) NOT NULL,
  `espacos_hotel_id_espacos` INT(7) NOT NULL,
  PRIMARY KEY (`id_funcionario`, `espacos_hotel_id_espacos`),
  CONSTRAINT `fk_funcionarios_espacos_hotel1`
    FOREIGN KEY (`espacos_hotel_id_espacos`)
    REFERENCES `mydb`.`espacos_hotel` (`id_espacos`));


-- -----------------------------------------------------
-- Table `mydb`.`reservas_espacos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`reservas_espacos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`reservas_espacos` (
  `id_reservas` INT(7) NOT NULL,
  `dia_horario` DATETIME NOT NULL,
  `num_identificacaof_clientes` INT(11) NOT NULL,
  `espacos_hotel_id_espacos` INT(11) NOT NULL,
  PRIMARY KEY (`id_reservas`, `num_identificacaof_clientes`, `espacos_hotel_id_espacos`),
  CONSTRAINT `fk_reservas_espacos_clientes1`
    FOREIGN KEY (`num_identificacaof_clientes`)
    REFERENCES `mydb`.`clientes` (`id_cliente`)
   ,
  CONSTRAINT `fk_reservas_espacos_espacos_hotel1`
    FOREIGN KEY (`espacos_hotel_id_espacos`)
    REFERENCES `mydb`.`espacos_hotel` (`id_espacos`)
    );


-- -----------------------------------------------------
-- Table `mydb`.`manutencao_espaco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`manutencao_espaco` ;

CREATE TABLE IF NOT EXISTS `mydb`.`manutencao_espaco` (
  `id_manutencao_espaco` INT NOT NULL,
  `dia` DATE NOT NULL,
  `hora_inicio` TIME NOT NULL,
  `hora_final` TIME NOT NULL,
  `tipo_manutencao` CHAR(1) NOT NULL,
  `espacos_hotel_id_espacos` INT(11) NOT NULL,
  `funcionarios_id_funcionario` INT(7) NOT NULL,
  `funcionarios_espacos_hotel_id_espacos` INT(7) NOT NULL,
  PRIMARY KEY (`id_manutencao_espaco`, `espacos_hotel_id_espacos`, `funcionarios_id_funcionario`, `funcionarios_espacos_hotel_id_espacos`),
  CONSTRAINT `fk_limpeza_espacos_espacos_hotel1`
    FOREIGN KEY (`espacos_hotel_id_espacos`)
    REFERENCES `mydb`.`espacos_hotel` (`id_espacos`),
  CONSTRAINT `fk_manutencao_espaco_funcionarios1`
    FOREIGN KEY (`funcionarios_id_funcionario` , `funcionarios_espacos_hotel_id_espacos`)
    REFERENCES `mydb`.`funcionarios` (`id_funcionario` , `espacos_hotel_id_espacos`));


-- -----------------------------------------------------
-- Table `mydb`.`limpeza_espaco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`limpeza_espaco` ;

CREATE TABLE IF NOT EXISTS `mydb`.`limpeza_espaco` (
  `id_limpeza` INT(7) NOT NULL,
  `tipo_limpeza` CHAR(1) NOT NULL,
  `horario_inicio` TIME NOT NULL,
  `horario_final` TIME NOT NULL,
  `dia` DATE NOT NULL,
  `espacos_hotel_id_espacos` INT(7) NOT NULL,
  `funcionarios_id_funcionario` INT(7) NOT NULL,
  `funcionarios_espacos_hotel_id_espacos` INT(7) NOT NULL,
  PRIMARY KEY (`id_limpeza`, `espacos_hotel_id_espacos`, `funcionarios_id_funcionario`, `funcionarios_espacos_hotel_id_espacos`),
  CONSTRAINT `fk_limpeza_hotel_espacos_hotel1`
    FOREIGN KEY (`espacos_hotel_id_espacos`)
    REFERENCES `mydb`.`espacos_hotel` (`id_espacos`),
  CONSTRAINT `fk_limpeza_hotel_funcionarios1`
    FOREIGN KEY (`funcionarios_id_funcionario` , `funcionarios_espacos_hotel_id_espacos`)
    REFERENCES `mydb`.`funcionarios` (`id_funcionario` , `espacos_hotel_id_espacos`));