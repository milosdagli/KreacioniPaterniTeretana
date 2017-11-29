CREATE DATABASE  IF NOT EXISTS `teretana` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `teretana`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: teretana
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
-- Table structure for table `clanovi`
--

DROP TABLE IF EXISTS `clanovi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clanovi` (
  `idclanovi` int(11) NOT NULL,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `paket` varchar(45) NOT NULL,
  `datumDo` date NOT NULL,
  PRIMARY KEY (`idclanovi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clanovi`
--

LOCK TABLES `clanovi` WRITE;
/*!40000 ALTER TABLE `clanovi` DISABLE KEYS */;
INSERT INTO `clanovi` VALUES (6,'Milos','Krsmanovic','obicni','2017-11-24'),(7,'Neko','Neko','bolji','2017-11-14'),(8,'Ivan','Ivanovic','najbolji','2017-11-14'),(9,'Marko','Markovic','bolji','2017-11-14'),(10,'Stefan','Jemuovic','najbolji','2017-11-30'),(11,'Jovan','Jovicic','obicni','2017-12-30'),(12,'Stefan','jemuovic','obicni','2017-11-14'),(13,'Janko','Ristanovic','najbolji','2017-01-26');
/*!40000 ALTER TABLE `clanovi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `counter`
--

DROP TABLE IF EXISTS `counter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `counter` (
  `TableName` varchar(45) NOT NULL,
  `counter` int(11) DEFAULT NULL,
  PRIMARY KEY (`TableName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counter`
--

LOCK TABLES `counter` WRITE;
/*!40000 ALTER TABLE `counter` DISABLE KEYS */;
INSERT INTO `counter` VALUES ('clanovi',13);
/*!40000 ALTER TABLE `counter` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-29  3:26:11
