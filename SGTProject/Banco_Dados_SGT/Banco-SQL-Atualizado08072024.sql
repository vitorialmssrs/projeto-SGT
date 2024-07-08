CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `num_identificacao` varchar(11) NOT NULL,
  `primeiro_nome` varchar(100) NOT NULL,
  `sobrenome` varchar(100) NOT NULL,
  `data_de_nascimento` date NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` int(8) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`id_cliente`, `num_identificacao`, `primeiro_nome`, `sobrenome`, `data_de_nascimento`, `telefone`, `email`, `senha`) VALUES (1,'78080932443','Putnam','Nowland','2013-08-01','(36) 72424-5142','pnowland0@tripadvisor.com',45678912),(2,'45345437765','Annalise','Mableson','2009-05-30','(51) 29504-5076','amableson1@e-recht24.de',65489421),(3,'99859850445','Winnie','Baribal','2016-05-26','(20) 16574-5955','wbaribal2@marketwatch.com',63214522),(4,'30912441445','Letti','Siemons','1988-09-20','(50) 51614-5525','lsiemons3@imageshack.us',85475621),(5,'76191405765','Leo','Skace','1987-12-31','(34) 27474-5070','lskace4@twitpic.com',96548745),(6,'51132384765','Granthem','Twelftree','1988-10-03','(14) 42754-5477','gtwelftree5@plala.or.jp',66161215),(7,'31609613445','Huberto','Barsby','2018-05-08','(78) 709724-559','hbarsby6@google.de',96518212),(8,'20268951765','Arnuad','Breem','2001-04-13','(43) 56984-5760','abreem7@istockphoto.com',96214631),(9,'70766435987','Abigail','Sellor','1988-09-27','(52) 84834-5532','asellor8@fc2.com',54231565),(10,'75712362234','Candy','Mathieu','2005-08-15','(91) 91754-5375','cmathieu9@china.com.cn',6321532),(11,'86266709234','Tonye','Linning','2004-11-25','(60) 99574-5204','tlinninga@opera.com',63215369),(12,'94503978987','Leann','Dobrovolny','2002-05-03','(73) 57904-5743','ldobrovolnyb@businessinsider.com',65486103),(13,'26336038234','Fowler','Gopsall','2022-07-08','(47) 10044-5270','fgopsallc@google.com',1341569),(14,'62164822765','Mort','Mart','1987-09-09','(35) 48744-5277','mmartd@a8.net',87500156),(15,'85035307765','Ingamar','Tutchener','2017-02-19','(14) 32934-5260','itutchenere@columbia.edu',63231205),(16,'93440157987','Hasty','Musto','1996-02-10','(57) 42904-5417','hmustof@nhs.uk',74852021),(17,'29886144987','Nickolaus','Roll','1993-01-31','(87) 45074-5689','nrollg@google.com',155121),(18,'95968706765','Claudetta','Wight','2014-06-13','(32) 69934-5532','cwighth@nyu.edu',5414596),(19,'12035834987','Domeniga','Nappin','2020-12-10','(38) 84794-5310','dnappini@wisc.edu',1204578),(20,'42491338234','Nichole','Stranio','1999-02-08','(32) 78174-5968','nstranioj@oakley.com',2105607);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `espacos_hotel`
--

DROP TABLE IF EXISTS `espacos_hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `espacos_hotel` (
  `id_espacos` int(7) NOT NULL AUTO_INCREMENT,
  `nome_espaco` varchar(100) NOT NULL,
  `dia_semana_abertura` date NOT NULL,
  `dia_semana_fechamento` date NOT NULL,
  `horario_abertura` time NOT NULL,
  `horario_fechamento` time NOT NULL,
  `capacidade` int(3) NOT NULL,
  PRIMARY KEY (`id_espacos`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `espacos_hotel`
--

LOCK TABLES `espacos_hotel` WRITE;
/*!40000 ALTER TABLE `espacos_hotel` DISABLE KEYS */;
INSERT INTO `espacos_hotel` (`id_espacos`, `nome_espaco`, `dia_semana_abertura`, `dia_semana_fechamento`, `horario_abertura`, `horario_fechamento`, `capacidade`) VALUES (1,'Academia','2023-01-03','2023-07-23','13:27:00','02:09:00',50),(2,'Psicina','2023-10-29','2023-02-21','00:33:00','00:07:00',80),(3,'Brinquedoteca','2023-07-09','2023-12-28','19:09:00','18:13:00',30),(4,'Quiosque','2023-09-06','2023-08-02','09:59:00','09:34:00',5),(5,'SPA','2023-10-08','2023-04-22','13:58:00','01:19:00',10),(6,'Sala de jogos','2023-06-13','2023-02-04','15:25:00','07:39:00',6),(7,'Quadra de vôlei','2023-11-28','2023-12-03','16:00:00','22:56:00',8),(8,'Quadra de vôlei','2023-01-20','2023-09-05','09:48:00','17:59:00',8),(9,'Quadra de futebol','2023-09-04','2023-10-30','16:30:00','22:08:00',10),(10,'Academia','2023-03-07','2023-04-16','11:56:00','11:34:00',6),(11,'Salão de festa','2023-04-24','2023-05-04','09:42:00','00:52:00',15),(12,'Salão de festa','2023-07-20','2023-03-24','23:37:00','09:44:00',20),(13,'Quiosque','2023-02-06','2023-06-10','02:30:00','10:50:00',12),(14,'Brinquedoteca','2023-07-14','2023-12-11','05:48:00','16:47:00',6),(15,'Psicina','2023-06-10','2023-06-27','09:03:00','04:41:00',100),(16,'Sala de jogos','2023-01-13','2023-10-15','04:48:00','07:09:00',80),(17,'Quiosque','2023-09-09','2023-01-28','13:37:00','05:33:00',20),(18,'SPA','2023-08-31','2023-09-19','21:43:00','11:04:00',5),(19,'Academia','2023-10-27','2023-08-26','14:15:00','17:17:00',4),(20,'Quadra de futebol','2023-07-25','2023-07-24','22:27:00','09:05:00',4);
/*!40000 ALTER TABLE `espacos_hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionarios`
--

DROP TABLE IF EXISTS `funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionarios` (
  `id_funcionario` int(7) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `num_identificacao` bigint(11) NOT NULL,
  `nome_completo` varchar(100) NOT NULL,
  `data_nascimento` date NOT NULL,
  `telefone` varchar(16) NOT NULL,
  `cep` int(8) NOT NULL,
  `num_casa` int(4) NOT NULL,
  PRIMARY KEY (`id_funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionarios`
--

LOCK TABLES `funcionarios` WRITE;
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
INSERT INTO `funcionarios` (`id_funcionario`, `login`, `senha`, `num_identificacao`, `nome_completo`, `data_nascimento`, `telefone`, `cep`, `num_casa`) VALUES (21,'gbydaway0','s5lRGZg',80279558948,'Winni Fust','2002-11-09','(55) 30545-12246',12345678,181),(22,'gmacpaike1','a3aAJ2p',51798654383,'Addy Beeby','2003-12-06','(20) 56746-78607',23456789,30),(23,'lormond2','g1AWE6R',36600142945,'Nate Dary','2003-07-17','(41) 30913-40051',34567890,32),(24,'dschruyers3','g3SLNdt',59820786099,'Lorinda Wyllie','2003-05-14','(98) 18282-95072',45678901,48),(25,'fswansborough4','l3KFzgf',68293762115,'Luciana Berthomier','2003-07-17','(36) 21570-09441',56789012,44),(26,'asimmank5','h8TuF4E',98784461294,'Martguerita Klimkov','2002-11-09','(50) 92911-67508',67890123,207),(27,'taviss6','c9EvM9a',22476559827,'Clement Tatershall','2003-02-17','(72) 43169-23646',78901234,27),(28,'sklossmann7','u9j3j52',11840432748,'Fern Blaw','2003-02-04','(48) 40285-23713',89012345,282),(29,'jhutcheon8','s9O2sj7',34484601536,'Thorstein Railton','2003-03-04','(35) 29851-67897',90123456,13),(30,'imonger9','k3b343w',34788143156,'Kynthia Fortman','2003-02-13','(67) 62556-88487',1234567,170),(31,'cedmondsona','l0eMDE1',62011924574,'Libbi Gallahue','2003-08-31','(87) 60131-27438',13579246,252),(32,'gcrickettb','k0RKzG0',16842105315,'Lenette Sallier','2003-01-06','(91) 68715-51266',24681357,227),(33,'thayhurstc','w3VeaHh',18645205830,'Charlton Corrison','2003-07-06','(32) 44598-44507',35792468,115),(34,'tnasebyd','k8ZqBd0',78290779822,'Nickie Manderson','2003-01-14','(47) 60111-64991',46813579,218),(35,'mbeazeye','u5Na6ul',14050244497,'Lesly Whiterod','2003-02-26','(50) 30329-22362',57924680,49),(36,'mglaisnerf','s90Ii9F',48452886351,'Augustine Levison','2002-11-15','(74) 33643-42140',68035791,812),(37,'nlafflingg','f76jHyA',54858538614,'Kally Lintin','2003-05-26','(22) 66238-29756',80257913,162),(38,'gconrathh','f70xt6l',91615917098,'Gil Daykin','2002-11-01','(36) 45036-43148',91368024,56),(39,'mferdinandi','g9Ocf7K',21602762177,'Benny Gabbitis','2003-07-10','(50) 62540-51373',79146802,59),(40,'uelementj','123',52867785212,'Fidelity Matisse','2002-07-12','(52) 69169-40001',2479135,498);
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospedagens`
--

DROP TABLE IF EXISTS `hospedagens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospedagens` (
  `num_quarto` int(3) NOT NULL AUTO_INCREMENT,
  `DataEntrada` date NOT NULL,
  `DataSaida` date DEFAULT NULL,
  `HoraEntrada` time NOT NULL,
  `HoraSaida` time DEFAULT NULL,
  `clientes_id_cliente` int(11) NOT NULL,
  PRIMARY KEY (`num_quarto`),
  KEY `fk_hospedagens_clientes1` (`clientes_id_cliente`),
  CONSTRAINT `fk_hospedagens_clientes1` FOREIGN KEY (`clientes_id_cliente`) REFERENCES `clientes` (`id_cliente`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospedagens`
--

LOCK TABLES `hospedagens` WRITE;
/*!40000 ALTER TABLE `hospedagens` DISABLE KEYS */;
INSERT INTO `hospedagens` (`num_quarto`, `DataEntrada`, `DataSaida`, `HoraEntrada`, `HoraSaida`, `clientes_id_cliente`) VALUES (1,'2023-11-16','2023-12-14','10:00:00','10:00:00',1),(2,'2023-05-10','2024-01-05','11:00:00','11:00:00',2),(3,'2023-07-21','2023-12-26','12:00:00','12:00:00',3),(4,'2023-06-04','2023-12-22','13:00:00','13:00:00',4),(5,'2023-11-02','2023-11-14','14:00:00','14:00:00',5),(6,'2023-10-06','2024-02-21','15:00:00','15:00:00',6),(7,'2023-09-10','2023-11-22','16:00:00','16:00:00',7),(8,'2023-08-26','2024-02-21','17:00:00','17:00:00',8),(9,'2023-10-20','2024-01-24','18:00:00','18:00:00',9),(10,'2023-04-20','2023-11-10','19:00:00','19:00:00',10),(11,'2023-11-23','2024-03-17','20:00:00','20:00:00',11),(12,'2023-10-30','2023-12-12','21:00:00','21:00:00',12),(13,'2023-12-18','2024-03-24','22:00:00','22:00:00',13),(14,'2023-09-30','2024-02-17','23:00:00','23:00:00',14),(15,'2023-12-21','2024-01-21','09:00:00','09:00:00',15),(16,'2023-12-12','2024-01-31','08:00:00','08:00:00',16),(17,'2023-04-04','2023-12-30','07:00:00','07:00:00',17),(18,'2023-05-28','2023-12-17','10:00:00','10:00:00',18),(19,'2023-05-03','2024-03-24','12:00:00','12:00:00',19),(20,'2023-11-09','2023-12-05','11:00:00','11:00:00',20);
/*!40000 ALTER TABLE `hospedagens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `limpeza_espaco`
--

DROP TABLE IF EXISTS `limpeza_espaco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `limpeza_espaco` (
  `id_limpeza` int(7) NOT NULL AUTO_INCREMENT,
  `tipo_limpeza` varchar(50) NOT NULL,
  `horario_inicio` time NOT NULL,
  `horario_final` time NOT NULL,
  `dia` date NOT NULL,
  `espacos_hotel_id_espacos` int(7) NOT NULL,
  `funcionarios_id_funcionario` int(7) NOT NULL,
  PRIMARY KEY (`id_limpeza`),
  KEY `fk_limpeza_espaco_espacos_hotel1` (`espacos_hotel_id_espacos`),
  KEY `fk_limpeza_espaco_funcionarios1` (`funcionarios_id_funcionario`),
  CONSTRAINT `fk_limpeza_espaco_espacos_hotel1` FOREIGN KEY (`espacos_hotel_id_espacos`) REFERENCES `espacos_hotel` (`id_espacos`),
  CONSTRAINT `fk_limpeza_espaco_funcionarios1` FOREIGN KEY (`funcionarios_id_funcionario`) REFERENCES `funcionarios` (`id_funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `limpeza_espaco`
--

LOCK TABLES `limpeza_espaco` WRITE;
/*!40000 ALTER TABLE `limpeza_espaco` DISABLE KEYS */;
INSERT INTO `limpeza_espaco` (`id_limpeza`, `tipo_limpeza`, `horario_inicio`, `horario_final`, `dia`, `espacos_hotel_id_espacos`, `funcionarios_id_funcionario`) VALUES (1,'limpeza piscina','06:00:00','06:30:00','2023-08-24',1,21),(2,'limpeza salão de festa','07:30:00','08:00:00','2023-02-15',2,22),(3,'limpeza quadra de futebol','16:00:00','16:30:00','2023-07-09',3,23),(4,'limpeza brinquedoteca','07:30:00','08:00:00','2023-02-08',4,24),(5,'limpeza quiosque','06:00:00','06:30:00','2023-06-29',5,25),(6,'limpeza quadra de volei','17:30:00','18:00:00','2023-07-13',6,26),(7,'limpeza sala de jogos','06:00:00','06:30:00','2023-12-07',7,27),(8,'limpeza quiosque','07:30:00','08:00:00','2023-01-07',8,28),(9,'limpeza academia','16:00:00','16:30:00','2023-04-01',9,29),(10,'limpeza piscina','07:30:00','08:00:00','2023-12-09',10,30),(11,'limpeza brinquedoteca','06:00:00','06:30:00','2023-07-04',11,31),(12,'limpeza salão de festa','17:30:00','16:00:00','2023-04-29',12,32),(13,'limpeza brinquedoteca','06:00:00','06:30:00','2023-01-20',13,33),(14,'limpeza quiosque','07:30:00','08:00:00','2023-05-22',14,34),(15,'limpeza quadra de volei','06:00:00','06:30:00','2023-10-04',15,35),(16,'limpeza SPA','07:30:00','08:00:00','2023-03-26',16,36),(17,'limpeza quiosque','16:00:00','16:30:00','2023-06-09',17,37),(18,'limpeza piscina','07:30:00','08:00:00','2023-10-08',18,38),(19,'limpeza academia','06:00:00','06:30:00','2023-10-02',19,39),(20,'limpeza brinquedoteca','07:30:00','08:00:00','2023-11-18',20,40);
/*!40000 ALTER TABLE `limpeza_espaco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manutencao_espaco`
--

DROP TABLE IF EXISTS `manutencao_espaco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manutencao_espaco` (
  `id_manutencao_espaco` int(11) NOT NULL AUTO_INCREMENT,
  `dia` date NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_final` time NOT NULL,
  `tipo_manutencao` varchar(100) NOT NULL,
  `espacos_hotel_id_espacos` int(11) NOT NULL,
  `funcionarios_id_funcionario` int(7) NOT NULL,
  `descricaomanutencao` varchar(100) NOT NULL,
  PRIMARY KEY (`id_manutencao_espaco`),
  KEY `fk_limpeza_espacos_espacos_hotel1` (`espacos_hotel_id_espacos`),
  KEY `fk_manutencao_espaco_funcionarios1` (`funcionarios_id_funcionario`),
  CONSTRAINT `fk_limpeza_espacos_espacos_hotel1` FOREIGN KEY (`espacos_hotel_id_espacos`) REFERENCES `espacos_hotel` (`id_espacos`),
  CONSTRAINT `fk_manutencao_espaco_funcionarios1` FOREIGN KEY (`funcionarios_id_funcionario`) REFERENCES `funcionarios` (`id_funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manutencao_espaco`
--

LOCK TABLES `manutencao_espaco` WRITE;
/*!40000 ALTER TABLE `manutencao_espaco` DISABLE KEYS */;
INSERT INTO `manutencao_espaco` (`id_manutencao_espaco`, `dia`, `hora_inicio`, `hora_final`, `tipo_manutencao`, `espacos_hotel_id_espacos`, `funcionarios_id_funcionario`, `descricaomanutencao`) VALUES (1,'2023-08-24','06:00:00','06:30:00','concerto piso',1,21,'caderra'),(2,'2023-02-15','07:30:00','08:00:00','concerto lampada',2,22,'caderra'),(3,'2023-07-09','16:00:00','16:30:00','concerto piso',3,23,'caderra'),(4,'2023-02-08','07:30:00','08:00:00','concerto supino',4,24,'caderra'),(5,'2023-06-29','06:00:00','06:30:00','concerto ar condicionado',5,25,'caderra'),(6,'2023-07-13','17:30:00','18:00:00','concerto piso',6,26,'caderra'),(7,'2023-12-07','06:00:00','06:30:00','concerto lampada',7,27,'caderra'),(8,'2023-01-07','07:30:00','08:00:00','concerto piso',8,28,'caderra'),(9,'2023-04-01','16:00:00','16:30:00','concerto janela',9,29,'caderra'),(10,'2023-12-09','07:30:00','08:00:00','concerto piso',10,30,'caderra'),(11,'2023-07-04','06:00:00','06:30:00','concerto piso',11,31,'caderra'),(12,'2023-04-29','17:30:00','16:00:00','concerto janela',12,32,'caderra'),(13,'2023-01-20','06:00:00','06:30:00','concerto piso',13,33,'caderra'),(14,'2023-05-22','07:30:00','08:00:00','concerto piso',14,34,'jogo'),(15,'2023-10-04','06:00:00','06:30:00','concerto lampada',15,35,'jogo'),(16,'2023-03-26','07:30:00','08:00:00','concerto janela',16,36,'jogo'),(17,'2023-06-09','16:00:00','16:30:00','concerto piso',17,37,'jogo'),(18,'2023-10-08','07:30:00','08:00:00','concerto supino',18,38,'jogo'),(19,'2023-10-02','06:00:00','06:30:00','concerto piso',19,39,'jogo'),(20,'2023-11-18','07:30:00','08:00:00','concerto ar condicionado',20,40,'jogo'),(21,'2024-04-10','12:00:00','13:00:00','Solicitação de conserto',4,40,'caderra');
/*!40000 ALTER TABLE `manutencao_espaco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas_espacos`
--

DROP TABLE IF EXISTS `reservas_espacos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservas_espacos` (
  `id_reservas` int(7) NOT NULL AUTO_INCREMENT,
  `dia_horario` datetime NOT NULL,
  `id_clientes` int(11) NOT NULL,
  `espacos_hotel_id_espacos` int(11) NOT NULL,
  PRIMARY KEY (`id_reservas`,`id_clientes`,`espacos_hotel_id_espacos`),
  KEY `fk_reservas_espacos_clientes1` (`id_clientes`),
  KEY `fk_reservas_espacos_espacos_hotel1` (`espacos_hotel_id_espacos`),
  CONSTRAINT `fk_reservas_espacos_clientes1` FOREIGN KEY (`id_clientes`) REFERENCES `clientes` (`id_cliente`) ON DELETE CASCADE,
  CONSTRAINT `fk_reservas_espacos_espacos_hotel1` FOREIGN KEY (`espacos_hotel_id_espacos`) REFERENCES `espacos_hotel` (`id_espacos`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas_espacos`
--

LOCK TABLES `reservas_espacos` WRITE;
/*!40000 ALTER TABLE `reservas_espacos` DISABLE KEYS */;
INSERT INTO `reservas_espacos` (`id_reservas`, `dia_horario`, `id_clientes`, `espacos_hotel_id_espacos`) VALUES (1,'2023-05-12 13:15:00',1,1),(2,'2022-11-13 20:00:00',2,2),(3,'2022-11-01 22:00:00',3,3),(4,'2023-07-21 14:00:00',4,4),(5,'2023-06-16 15:00:00',5,5),(6,'2023-12-21 17:00:00',6,6),(7,'2022-09-24 21:00:00',7,7),(8,'2023-10-20 00:00:00',8,8),(9,'2023-07-17 15:00:00',9,9),(10,'2022-07-17 18:00:00',10,10),(11,'2023-04-30 19:00:00',11,11),(12,'2023-05-23 04:00:00',12,12),(13,'2023-11-08 16:00:00',13,13),(14,'2022-10-11 06:00:00',14,14),(15,'2022-05-16 09:00:00',15,15),(16,'2023-03-11 11:00:00',16,16),(17,'2023-04-04 12:00:00',17,17),(18,'2022-11-20 10:00:00',18,18),(19,'2023-06-21 05:00:00',19,19),(20,'2023-06-06 20:00:00',20,20);
/*!40000 ALTER TABLE `reservas_espacos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'mydb'
--

--
-- Dumping routines for database 'mydb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-08 12:00:41
