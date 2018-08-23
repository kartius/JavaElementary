-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: group_manager
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.16.04.1

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
-- Table structure for table `school_class`
--

DROP TABLE IF EXISTS `school_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `school_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `school_class_id_uindex` (`id`),
  UNIQUE KEY `school_class_level_uindex` (`level`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school_class`
--

LOCK TABLES `school_class` WRITE;
/*!40000 ALTER TABLE `school_class` DISABLE KEYS */;
INSERT INTO `school_class` VALUES (1,1);
/*!40000 ALTER TABLE `school_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Petr',0),(2,'Ivan',0),(3,'Fedor',0),(4,'Petr',0),(5,'Ivan',0),(6,'Fedor',0),(7,'Petr',0),(8,'Ivan',0),(9,'Fedor',0),(10,'Petr',0),(11,'Ivan',0),(12,'Fedor',0),(13,'Petr',0),(14,'Ivan',0),(15,'Fedor',0),(16,'Petr',1),(17,'Ivan',1),(18,'Fedor',1),(19,'Petr',1),(20,'Ivan',1),(21,'Fedor',1),(22,'Petr',1),(23,'Ivan',1),(24,'Fedor',1),(25,'Petr',1),(26,'Ivan',1),(27,'Fedor',1),(28,'Petr',1),(29,'Ivan',1),(30,'Fedor',1),(31,'Petr',1),(32,'Ivan',1),(33,'Fedor',1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `school_class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `subject_id_uindex` (`id`),
  KEY `subject_school_class_id_fk` (`school_class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (43,'History',0),(44,'Math',0),(45,'Geography',0),(46,'Phylosophy',0),(47,'IT',0),(48,'Languages',0),(49,'History',0),(50,'Math',0),(51,'Geography',0),(52,'Phylosophy',0),(53,'IT',0),(54,'Languages',0),(55,'History',0),(56,'Math',0),(57,'Geography',0),(58,'Phylosophy',0),(59,'IT',0),(60,'Languages',0),(61,'History',0),(62,'Math',0),(63,'Geography',0),(64,'Phylosophy',0),(65,'IT',0),(66,'Languages',0),(67,'History',0),(68,'Math',0),(69,'Geography',0),(70,'Phylosophy',0),(71,'IT',0),(72,'Languages',0),(73,'History',0),(74,'History',1),(75,'Math',1),(76,'Geography',1),(77,'Phylosophy',1),(78,'IT',1),(79,'Languages',1),(80,'History',1),(81,'Math',1),(82,'Geography',1),(83,'Phylosophy',1),(84,'IT',1),(85,'Languages',1),(86,'History',1),(87,'Math',1),(88,'Geography',1),(89,'Phylosophy',1),(90,'IT',1),(91,'Languages',1),(92,'History',1),(93,'Math',1),(94,'Geography',1),(95,'Phylosophy',1),(96,'IT',1),(97,'Languages',1),(98,'History',1),(99,'Math',1),(100,'Geography',1),(101,'Phylosophy',1),(102,'IT',1),(103,'Languages',1),(104,'History',1),(105,'Math',1),(106,'Geography',1),(107,'Phylosophy',1),(108,'IT',1),(109,'Languages',1),(110,'History',1),(111,'Math',1),(112,'Geography',1),(113,'Phylosophy',1),(114,'IT',1),(115,'Languages',1),(116,'History',1),(117,'Math',1),(118,'Geography',1),(119,'Phylosophy',1),(120,'IT',1),(121,'Languages',1),(122,'History',1),(123,'Math',1),(124,'Geography',1),(125,'Phylosophy',1),(126,'IT',1),(127,'Languages',1),(128,'History',1),(129,'Math',1),(130,'Geography',1),(131,'Phylosophy',1),(132,'IT',1),(133,'Languages',1),(134,'History',1),(135,'Math',1),(136,'Geography',1),(137,'Phylosophy',1),(138,'IT',1),(139,'Languages',1),(140,'History',1),(141,'Math',1),(142,'Geography',1),(143,'Phylosophy',1),(144,'IT',1),(145,'Languages',1),(146,'History',1),(147,'Math',1),(148,'Geography',1),(149,'Phylosophy',1),(150,'IT',1),(151,'Languages',1),(152,'History',1),(153,'Math',1),(154,'Geography',1),(155,'Phylosophy',1),(156,'IT',1),(157,'Languages',1),(158,'History',1),(159,'Math',1),(160,'Geography',1),(161,'Phylosophy',1),(162,'IT',1),(163,'Languages',1),(164,'History',1),(165,'Math',1),(166,'Geography',1),(167,'Phylosophy',1),(168,'IT',1),(169,'Languages',1),(170,'History',1),(171,'Math',1),(172,'Geography',1),(173,'Phylosophy',1),(174,'IT',1),(175,'Languages',1),(176,'History',1),(177,'Math',1),(178,'Geography',1),(179,'Phylosophy',1),(180,'IT',1),(181,'Languages',1);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (3),(3),(4),(4),(4),(45),(45),(45),(45),(45);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-23  9:24:59
