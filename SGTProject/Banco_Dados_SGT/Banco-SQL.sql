-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP DATABASE IF EXISTS mydb;

CREATE DATABASE IF NOT EXISTS mydb;

USE mydb;

-- -----------------------------------------------------
-- Table clientes
-- -----------------------------------------------------
DROP TABLE IF EXISTS clientes;

CREATE TABLE IF NOT EXISTS clientes (
  id_cliente INT(11) NOT NULL AUTO_INCREMENT,
  num_identificacao bigint(11) NOT NULL,
  primeiro_nome VARCHAR(100) NOT NULL,
  sobrenome VARCHAR(100) NOT NULL,
  data_de_nascimento DATE NOT NULL,
  telefone varchar(15) NOT NULL,
  email VARCHAR(50) NOT NULL,
  senha INT(8) NOT NULL,
  PRIMARY KEY (id_cliente)
);

-- -----------------------------------------------------
-- Table espacos_hotel
-- -----------------------------------------------------
DROP TABLE IF EXISTS espacos_hotel;

CREATE TABLE IF NOT EXISTS espacos_hotel (
  id_espacos INT(7) NOT NULL auto_increment,
  nome_espaco VARCHAR(100) NOT NULL,
  dia_semana_abertura DATE NOT NULL,
  dia_semana_fechamento DATE NOT NULL,
  horario_abertura TIME NOT NULL,
  horario_fechamento TIME NOT NULL,
  capacidade INT(3) NOT NULL,
  PRIMARY KEY (id_espacos)
);

-- -----------------------------------------------------
-- Table funcionarios
-- -----------------------------------------------------
DROP TABLE IF EXISTS funcionarios;

CREATE TABLE IF NOT EXISTS funcionarios (
  id_funcionario INT(7) NOT NULL AUTO_INCREMENT,
  login VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  num_identificacao bigint(11) NOT NULL,
  nome_completo VARCHAR(100) NOT NULL,
  data_nascimento DATE NOT NULL,
  telefone varchar(16) NOT NULL,
  cep INT(8) NOT NULL,
  num_casa INT(4) NOT NULL,
  PRIMARY KEY (id_funcionario)
);

-- -----------------------------------------------------
-- Table reservas_espacos
-- -----------------------------------------------------
DROP TABLE IF EXISTS reservas_espacos;

CREATE TABLE IF NOT EXISTS reservas_espacos (
  id_reservas INT(7) NOT NULL,
  dia_horario DATETIME NOT NULL,
  id_clientes INT(11) NOT NULL,
  espacos_hotel_id_espacos INT(11) NOT NULL,
  PRIMARY KEY (
    id_reservas,
    id_clientes,
    espacos_hotel_id_espacos
  ),
  CONSTRAINT fk_reservas_espacos_clientes1 FOREIGN KEY (id_clientes) REFERENCES clientes (id_cliente),
  CONSTRAINT fk_reservas_espacos_espacos_hotel1 FOREIGN KEY (espacos_hotel_id_espacos) REFERENCES espacos_hotel (id_espacos)
);

-- -----------------------------------------------------
-- Table hospedagens
-- -----------------------------------------------------
DROP TABLE IF EXISTS hospedagens;

CREATE TABLE IF NOT EXISTS hospedagens (
  num_quarto INT(3) NOT NULL,
  DataEntrada DATE NOT NULL,
  DataSaida DATE,
  HoraEntrada TIME NOT NULL,
  HoraSaida TIME,
  clientes_id_cliente INT(11) NOT NULL,
  PRIMARY KEY (num_quarto),
  CONSTRAINT fk_hospedagens_clientes1 FOREIGN KEY (clientes_id_cliente) REFERENCES clientes (id_cliente)
);

-- -----------------------------------------------------
-- Table manutencao_espaco
-- -----------------------------------------------------
DROP TABLE IF EXISTS manutencao_espaco;

CREATE TABLE IF NOT EXISTS manutencao_espaco (
  id_manutencao_espaco INT NOT NULL auto_increment,
  dia DATE NOT NULL,
  hora_inicio TIME NOT NULL,
  hora_final TIME NOT NULL,
  tipo_manutencao varchar(100) NOT NULL,
  espacos_hotel_id_espacos INT(11) NOT NULL,
  funcionarios_id_funcionario INT(7) NOT NULL,
  PRIMARY KEY (id_manutencao_espaco),
  CONSTRAINT fk_limpeza_espacos_espacos_hotel1 FOREIGN KEY (espacos_hotel_id_espacos) REFERENCES espacos_hotel (id_espacos),
  CONSTRAINT fk_manutencao_espaco_funcionarios1 FOREIGN KEY (funcionarios_id_funcionario) REFERENCES funcionarios (id_funcionario)
);

-- -----------------------------------------------------
-- Table limpeza_espaco
-- -----------------------------------------------------
DROP TABLE IF EXISTS limpeza_espaco;

CREATE TABLE IF NOT EXISTS limpeza_espaco (
  id_limpeza INT(7) NOT NULL auto_increment,
  tipo_limpeza VARCHAR(50) NOT NULL,
  horario_inicio TIME NOT NULL,
  horario_final TIME NOT NULL,
  dia DATE NOT NULL,
  espacos_hotel_id_espacos INT(7) NOT NULL,
  funcionarios_id_funcionario INT(7) NOT NULL,
  PRIMARY KEY (id_limpeza),
  CONSTRAINT fk_limpeza_espaco_espacos_hotel1 FOREIGN KEY (espacos_hotel_id_espacos) REFERENCES espacos_hotel (id_espacos),
  CONSTRAINT fk_limpeza_espaco_funcionarios1 FOREIGN KEY (funcionarios_id_funcionario) REFERENCES funcionarios (id_funcionario)
);

-- -----------------------
-- desc
-- -----------------------
DESC hospedagens;

DESC clientes;

DESC espacos_hotel;

DESC funcionarios;

DESC reservas_espacos;

DESC manutencao_espaco;

DESC limpeza_espaco;

-- -----------
-- INSERTS
-- -----------
-- HOSPEDE/CLIENTE
insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '78080932443',
    'Putnam',
    'Nowland',
    '2013-08-01',
    'pnowland0@tripadvisor.com',
    '(36) 72424-5142',
    1,
    45678912
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '45345437765',
    'Annalise',
    'Mableson',
    '2009-05-30',
    'amableson1@e-recht24.de',
    '(51) 29504-5076',
    2,
    65489421
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '99859850445',
    'Winnie',
    'Baribal',
    '2016-05-26',
    'wbaribal2@marketwatch.com',
    '(20) 16574-5955',
    3,
    63214522
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '30912441445',
    'Letti',
    'Siemons',
    '1988-09-20',
    'lsiemons3@imageshack.us',
    '(50) 51614-5525',
    4,
    85475621
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '76191405765',
    'Leo',
    'Skace',
    '1987-12-31',
    'lskace4@twitpic.com',
    '(34) 27474-5070',
    5,
    96548745
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '51132384765',
    'Granthem',
    'Twelftree',
    '1988-10-03',
    'gtwelftree5@plala.or.jp',
    '(14) 42754-5477',
    6,
    66161215
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '31609613445',
    'Huberto',
    'Barsby',
    '2018-05-08',
    'hbarsby6@google.de',
    '(78) 709724-559',
    7,
    96518212
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '20268951765',
    'Arnuad',
    'Breem',
    '2001-04-13',
    'abreem7@istockphoto.com',
    '(43) 56984-5760',
    8,
    96214631
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '70766435987',
    'Abigail',
    'Sellor',
    '1988-09-27',
    'asellor8@fc2.com',
    '(52) 84834-5532',
    9,
    54231565
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '75712362234',
    'Candy',
    'Mathieu',
    '2005-08-15',
    'cmathieu9@china.com.cn',
    '(91) 91754-5375',
    10,
    6321532
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '86266709234',
    'Tonye',
    'Linning',
    '2004-11-25',
    'tlinninga@opera.com',
    '(60) 99574-5204',
    11,
    63215369
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '94503978987',
    'Leann',
    'Dobrovolny',
    '2002-05-03',
    'ldobrovolnyb@businessinsider.com',
    '(73) 57904-5743',
    12,
    65486103
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '26336038234',
    'Fowler',
    'Gopsall',
    '2022-07-08',
    'fgopsallc@google.com',
    '(47) 10044-5270',
    13,
    01341569
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '62164822765',
    'Mort',
    'Mart',
    '1987-09-09',
    'mmartd@a8.net',
    '(35) 48744-5277',
    14,
    87500156
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '85035307765',
    'Ingamar',
    'Tutchener',
    '2017-02-19',
    'itutchenere@columbia.edu',
    '(14) 32934-5260',
    15,
    63231205
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '93440157987',
    'Hasty',
    'Musto',
    '1996-02-10',
    'hmustof@nhs.uk',
    '(57) 42904-5417',
    16,
    74852021
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '29886144987',
    'Nickolaus',
    'Roll',
    '1993-01-31',
    'nrollg@google.com',
    '(87) 45074-5689',
    17,
    00155121
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '95968706765',
    'Claudetta',
    'Wight',
    '2014-06-13',
    'cwighth@nyu.edu',
    '(32) 69934-5532',
    18,
    05414596
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '12035834987',
    'Domeniga',
    'Nappin',
    '2020-12-10',
    'dnappini@wisc.edu',
    '(38) 84794-5310',
    19,
    01204578
  );

insert into
  clientes (
    num_identificacao,
    primeiro_nome,
    sobrenome,
    data_de_nascimento,
    email,
    telefone,
    id_cliente,
    senha
  )
values
  (
    '42491338234',
    'Nichole',
    'Stranio',
    '1999-02-08',
    'nstranioj@oakley.com',
    '(32) 78174-5968',
    20,
    02105607
  );

-- INSERT HOSPEDAGEM
insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (1, '2023-11-16', '10:00', '2023-12-14', '10:00', 1);

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (2, '2023-05-10', '11:00', '2024-01-05', '11:00', 2);

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (3, '2023-07-21', '12:00', '2023-12-26', '12:00', 3);

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (4, '2023-06-04', '13:00', '2023-12-22', '13:00', 4);

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (5, '2023-11-02', '14:00', '2023-11-14', '14:00', 5);

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (6, '2023-10-06', '15:00', '2024-02-21', '15:00', 6);

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (7, '2023-09-10', '16:00', '2023-11-22', '16:00', 7);

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (8, '2023-08-26', '17:00', '2024-02-21', '17:00', 8);

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (9, '2023-10-20', '18:00', '2024-01-24', '18:00', 9);

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (
    10,
    '2023-04-20',
    '19:00',
    '2023-11-10',
    '19:00',
    10
  );

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (
    11,
    '2023-11-23',
    '20:00',
    '2024-03-17',
    '20:00',
    11
  );

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (
    12,
    '2023-10-30',
    '21:00',
    '2023-12-12',
    '21:00',
    12
  );

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (
    13,
    '2023-12-18',
    '22:00',
    '2024-03-24',
    '22:00',
    13
  );

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (
    14,
    '2023-09-30',
    '23:00',
    '2024-02-17',
    '23:00',
    14
  );

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (
    15,
    '2023-12-21',
    '09:00',
    '2024-01-21',
    '09:00',
    15
  );

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (
    16,
    '2023-12-12',
    '08:00',
    '2024-01-31',
    '08:00',
    16
  );

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (
    17,
    '2023-04-04',
    '07:00',
    '2023-12-30',
    '07:00',
    17
  );

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (
    18,
    '2023-05-28',
    '10:00',
    '2023-12-17',
    '10:00',
    18
  );

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (
    19,
    '2023-05-03',
    '12:00',
    '2024-03-24',
    '12:00',
    19
  );

insert into
  hospedagens (
    num_quarto,
    DataEntrada,
    HoraEntrada,
    DataSaida,
    HoraSaida,
    clientes_id_cliente
  )
values
  (
    20,
    '2023-11-09',
    '11:00',
    '2023-12-05',
    '11:00',
    20
  );

-- Espaço-Hotel
insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Academia',
    '2023-01-03',
    '2023-07-23',
    '13:27',
    '2:09',
    50
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Psicina',
    '2023-10-29',
    '2023-02-21',
    '0:33',
    '0:07',
    80
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Brinquedoteca',
    '2023-07-09',
    '2023-12-28',
    '19:09',
    '18:13',
    30
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Quiosque',
    '2023-09-06',
    '2023-08-02',
    '9:59',
    '9:34',
    5
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'SPA',
    '2023-10-08',
    '2023-04-22',
    '13:58',
    '1:19',
    10
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Sala de jogos',
    '2023-06-13',
    '2023-02-04',
    '15:25',
    '7:39',
    6
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Quadra de vôlei',
    '2023-11-28',
    '2023-12-03',
    '16:00',
    '22:56',
    8
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Quadra de vôlei',
    '2023-01-20',
    '2023-09-05',
    '9:48',
    '17:59',
    8
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Quadra de futebol',
    '2023-09-04',
    '2023-10-30',
    '16:30',
    '22:08',
    10
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Academia',
    '2023-03-07',
    '2023-04-16',
    '11:56',
    '11:34',
    6
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Salão de festa',
    '2023-04-24',
    '2023-05-04',
    '9:42',
    '0:52',
    15
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Salão de festa',
    '2023-07-20',
    '2023-03-24',
    '23:37',
    '9:44',
    20
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Quiosque',
    '2023-02-06',
    '2023-06-10',
    '2:30',
    '10:50',
    12
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Brinquedoteca',
    '2023-07-14',
    '2023-12-11',
    '5:48',
    '16:47',
    6
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Psicina',
    '2023-06-10',
    '2023-06-27',
    '9:03',
    '4:41',
    100
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Sala de jogos',
    '2023-01-13',
    '2023-10-15',
    '4:48',
    '7:09',
    80
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Quiosque',
    '2023-09-09',
    '2023-01-28',
    '13:37',
    '5:33',
    20
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'SPA',
    '2023-08-31',
    '2023-09-19',
    '21:43',
    '11:04',
    5
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Academia',
    '2023-10-27',
    '2023-08-26',
    '14:15',
    '17:17',
    4
  );

insert into
  espacos_hotel (
    nome_espaco,
    dia_semana_abertura,
    dia_semana_fechamento,
    horario_abertura,
    horario_fechamento,
    capacidade
  )
values
  (
    'Quadra de futebol',
    '2023-07-25',
    '2023-07-24',
    '22:27',
    '9:05',
    4
  );

-- Funcionarios
insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    80279558948,
    'gbydaway0',
    's5lRGZg',
    'Winni Fust',
    '2002-11-09',
    '(55) 30545-12246',
    '12345678',
    '181',
    21
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    51798654383,
    'gmacpaike1',
    'a3aAJ2p',
    'Addy Beeby',
    '2003-12-06',
    '(20) 56746-78607',
    '23456789',
    '30',
    22
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    36600142945,
    'lormond2',
    'g1AWE6R',
    'Nate Dary',
    '2003-07-17',
    '(41) 30913-40051',
    '34567890',
    '32',
    23
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    59820786099,
    'dschruyers3',
    'g3SLNdt',
    'Lorinda Wyllie',
    '2003-05-14',
    '(98) 18282-95072',
    '45678901',
    '48',
    24
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    68293762115,
    'fswansborough4',
    'l3KFzgf',
    'Luciana Berthomier',
    '2003-07-17',
    '(36) 21570-09441',
    '56789012',
    '44',
    25
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    98784461294,
    'asimmank5',
    'h8TuF4E',
    'Martguerita Klimkov',
    '2002-11-09',
    '(50) 92911-67508',
    '67890123',
    '207',
    26
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    22476559827,
    'taviss6',
    'c9EvM9a',
    'Clement Tatershall',
    '2003-02-17',
    '(72) 43169-23646',
    '78901234',
    '27',
    27
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    11840432748,
    'sklossmann7',
    'u9j3j52',
    'Fern Blaw',
    '2003-02-04',
    '(48) 40285-23713',
    '89012345',
    '282',
    28
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    34484601536,
    'jhutcheon8',
    's9O2sj7',
    'Thorstein Railton',
    '2003-03-04',
    '(35) 29851-67897',
    '90123456',
    '13',
    29
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    34788143156,
    'imonger9',
    'k3b343w',
    'Kynthia Fortman',
    '2003-02-13',
    '(67) 62556-88487',
    '01234567',
    '170',
    30
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    62011924574,
    'cedmondsona',
    'l0eMDE1',
    'Libbi Gallahue',
    '2003-08-31',
    '(87) 60131-27438',
    '13579246',
    '252',
    31
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    16842105315,
    'gcrickettb',
    'k0RKzG0',
    'Lenette Sallier',
    '2003-01-06',
    '(91) 68715-51266',
    '24681357',
    '227',
    32
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    18645205830,
    'thayhurstc',
    'w3VeaHh',
    'Charlton Corrison',
    '2003-07-06',
    '(32) 44598-44507',
    '35792468',
    '115',
    33
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    78290779822,
    'tnasebyd',
    'k8ZqBd0',
    'Nickie Manderson',
    '2003-01-14',
    '(47) 60111-64991',
    '46813579',
    '218',
    34
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    14050244497,
    'mbeazeye',
    'u5Na6ul',
    'Lesly Whiterod',
    '2003-02-26',
    '(50) 30329-22362',
    '57924680',
    '49',
    35
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    48452886351,
    'mglaisnerf',
    's90Ii9F',
    'Augustine Levison',
    '2002-11-15',
    '(74) 33643-42140',
    '68035791',
    '812',
    36
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    54858538614,
    'nlafflingg',
    'f76jHyA',
    'Kally Lintin',
    '2003-05-26',
    '(22) 66238-29756',
    '80257913',
    '162',
    37
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    91615917098,
    'gconrathh',
    'f70xt6l',
    'Gil Daykin',
    '2002-11-01',
    '(36) 45036-43148',
    '91368024',
    '56',
    38
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    21602762177,
    'mferdinandi',
    'g9Ocf7K',
    'Benny Gabbitis',
    '2003-07-10',
    '(50) 62540-51373',
    '79146802',
    '59',
    39
  );

insert into
  funcionarios (
    num_identificacao,
    login,
    senha,
    nome_completo,
    data_nascimento,
    telefone,
    cep,
    num_casa,
    id_funcionario
  )
values
  (
    52867785212,
    'uelementj',
    'c8zZ05a',
    'Fidelity Matisse',
    '2002-07-12',
    '(52) 69169-40001',
    '02479135',
    '498',
    40
  );

-- Reservas_espacos
insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (1, '2023-05-12 13:15', 1, 1);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (2, '2022-11-13 20:00', 2, 2);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (3, '2022-11-01 22:00', 3, 3);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (4, '2023-07-21 14:00', 4, 4);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (5, '2023-06-16 15:00', 5, 5);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (6, '2023-12-21 17:00', 6, 6);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (7, '2022-09-24 21:00', 7, 7);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (8, '2023-10-20 00:00', 8, 8);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (9, '2023-07-17 15:00', 9, 9);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (10, '2022-07-17 18:00', 10, 10);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (11, '2023-04-30 19:00', 11, 11);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (12, '2023-05-23 04:00', 12, 12);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (13, '2023-11-08 16:00', 13, 13);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (14, '2022-10-11 06:00', 14, 14);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (15, '2022-05-16 09:00', 15, 15);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (16, '2023-03-11 11:00', 16, 16);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (17, '2023-04-04 12:00', 17, 17);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (18, '2022-11-20 10:00', 18, 18);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (19, '2023-06-21 05:00', 19, 19);

insert into
  reservas_espacos (
    id_reservas,
    dia_horario,
    id_clientes,
    espacos_hotel_id_espacos
  )
values
  (20, '2023-06-06 20:00', 20, 20);

-- Manutencao_espaco
insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-08-24',
    '06:00',
    '06:30',
    'concerto piso',
    1,
    21
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-02-15',
    '07:30',
    '08:00',
    'concerto lampada',
    2,
    22
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-07-09',
    '16:00',
    '16:30',
    'concerto piso',
    3,
    23
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-02-08',
    '07:30',
    '08:00',
    'concerto supino',
    4,
    24
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-06-29',
    '06:00',
    '06:30',
    'concerto ar condicionado',
    5,
    25
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-07-13',
    '17:30',
    '18:00',
    'concerto piso',
    6,
    26
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-12-07',
    '06:00',
    '06:30',
    'concerto lampada',
    7,
    27
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-01-07',
    '07:30',
    '08:00',
    'concerto piso',
    8,
    28
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-04-01',
    '16:00',
    '16:30',
    'concerto janela',
    9,
    29
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-12-09',
    '07:30',
    '08:00',
    'concerto piso',
    10,
    30
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-07-04',
    '06:00',
    '06:30',
    'concerto piso',
    11,
    31
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-04-29',
    '17:30',
    '16:00',
    'concerto janela',
    12,
    32
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-01-20',
    '06:00',
    '06:30',
    'concerto piso',
    13,
    33
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-05-22',
    '07:30',
    '08:00',
    'concerto piso',
    14,
    34
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-10-04',
    '06:00',
    '06:30',
    'concerto lampada',
    15,
    35
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-03-26',
    '07:30',
    '08:00',
    'concerto janela',
    16,
    36
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-06-09',
    '16:00',
    '16:30',
    'concerto piso',
    17,
    37
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-10-08',
    '07:30',
    '08:00',
    'concerto supino',
    18,
    38
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-10-02',
    '06:00',
    '06:30',
    'concerto piso',
    19,
    39
  );

insert into
  manutencao_espaco (
    dia,
    hora_inicio,
    hora_final,
    tipo_manutencao,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-11-18',
    '07:30',
    '08:00',
    'concerto ar condicionado',
    20,
    40
  );

-- Limpeza_espaco
insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-08-24',
    '06:00',
    '06:30',
    'limpeza piscina',
    1,
    21
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-02-15',
    '07:30',
    '08:00',
    'limpeza salão de festa',
    2,
    22
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-07-09',
    '16:00',
    '16:30',
    'limpeza quadra de futebol',
    3,
    23
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-02-08',
    '07:30',
    '08:00',
    'limpeza brinquedoteca',
    4,
    24
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023=06=29',
    '06:00',
    '06:30',
    'limpeza quiosque',
    5,
    25
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-07-13',
    '17:30',
    '18:00',
    'limpeza quadra de volei',
    6,
    26
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-12-07',
    '06:00',
    '06:30',
    'limpeza sala de jogos',
    7,
    27
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-01-07',
    '07:30',
    '08:00',
    'limpeza quiosque',
    8,
    28
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-04-01',
    '16:00',
    '16:30',
    'limpeza academia',
    9,
    29
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-12-09',
    '07:30',
    '08:00',
    'limpeza piscina',
    10,
    30
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-07-04',
    '06:00',
    '06:30',
    'limpeza brinquedoteca',
    11,
    31
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-04-29',
    '17:30',
    '16:00',
    'limpeza salão de festa',
    12,
    32
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-01-20',
    '06:00',
    '06:30',
    'limpeza brinquedoteca',
    13,
    33
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-05-22',
    '07:30',
    '08:00',
    'limpeza quiosque',
    14,
    34
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-10-04',
    '06:00',
    '06:30',
    'limpeza quadra de volei',
    15,
    35
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-03-26',
    '07:30',
    '08:00',
    'limpeza SPA',
    16,
    36
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-06-09',
    '16:00',
    '16:30',
    'limpeza quiosque',
    17,
    37
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-10-08',
    '07:30',
    '08:00',
    'limpeza piscina',
    18,
    38
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-10-02',
    '06:00',
    '06:30',
    'limpeza academia',
    19,
    39
  );

insert into
  limpeza_espaco (
    dia,
    horario_inicio,
    horario_final,
    tipo_limpeza,
    espacos_hotel_id_espacos,
    funcionarios_id_funcionario
  )
values
  (
    '2023-11-18',
    '07:30',
    '08:00',
    'limpeza brinquedoteca',
    20,
    40
  );

-- ---------------
-- SELECTS 
-- ----------------
SELECT
  *
FROM
  hospedagens;

SELECT
  *
FROM
  clientes;

SELECT
  *
FROM
  espacos_hotel;

SELECT
  *
FROM
  funcionarios;

SELECT
  *
FROM
  reservas_espacos;

SELECT
  *
FROM
  manutencao_espaco;

SELECT
  *
FROM
  limpeza_espaco;