-- MySQL dump 10.13  Distrib 9.4.0, for Win64 (x86_64)
--
-- Host: localhost    Database: control_access
-- ------------------------------------------------------
-- Server version	9.4.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `campus`
--

DROP TABLE IF EXISTS `campus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campus` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ID_SCHOOL` int NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `SHORT_NAME` varchar(100) NOT NULL,
  `NIT` varchar(20) NOT NULL,
  `DIRECCION` varchar(200) DEFAULT NULL,
  `TELEFONO` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `OPERATIVE_STATUS` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME` (`NAME`,`ID_SCHOOL`,`NIT`),
  KEY `ID_SCHOOL` (`ID_SCHOOL`),
  CONSTRAINT `campus_ibfk_1` FOREIGN KEY (`ID_SCHOOL`) REFERENCES `school` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campus`
--

LOCK TABLES `campus` WRITE;
/*!40000 ALTER TABLE `campus` DISABLE KEYS */;
/*!40000 ALTER TABLE `campus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fingerprint`
--

DROP TABLE IF EXISTS `fingerprint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fingerprint` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `ID_USER` int NOT NULL,
  `finger` tinytext,
  `template` tinytext NOT NULL,
  `REGISTRY_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `ID_USER` (`ID_USER`),
  CONSTRAINT `fingerprint_ibfk_1` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fingerprint`
--

LOCK TABLES `fingerprint` WRITE;
/*!40000 ALTER TABLE `fingerprint` DISABLE KEYS */;
INSERT INTO `fingerprint` VALUES (1,1,'pulgar_derecho','qa','2025-10-21 00:22:55'),(2,1,'indice_derecho','qa2','2025-10-21 00:25:37');
/*!40000 ALTER TABLE `fingerprint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grade` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `grade_unit` varchar(3) NOT NULL,
  `group_unit` varchar(3) NOT NULL,
  `DEFAULT_ENTRY_TIME` time DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1,'6','3',NULL),(3,'7','1','06:00:00'),(4,'6','2','06:00:00'),(5,'6','1','06:00:00');
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `school` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `NIT` varchar(20) NOT NULL,
  `CREATED_AT` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NIT` (`NIT`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ID_USER` int NOT NULL,
  `GRADE_GROUP` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `GRADE_GROUP` (`GRADE_GROUP`),
  KEY `ID_USER` (`ID_USER`),
  CONSTRAINT `student_grade_fk` FOREIGN KEY (`GRADE_GROUP`) REFERENCES `grade` (`ID`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,1,1),(2,21,3),(3,22,4),(4,23,5);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(100) NOT NULL,
  `SECOND_NAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `FIRST_LAST_NAME` varchar(100) NOT NULL,
  `SECOND_LAST_NAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `USERNAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `IDENTIFICATION` varchar(50) NOT NULL,
  `PASSWORD_HASH` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ACTIVE` tinyint(1) DEFAULT '1',
  `CREATED_AT` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`),
  UNIQUE KEY `IDENTIFICATION` (`IDENTIFICATION`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'jon','doe','lorem','ipsum','test@testmail.com','jon.lorem','1223456789','sflkñafñlkjasdñlfkjasdñfklj',1,'2025-10-21 05:21:48'),(2,'Yahir','Esteban','Ramirez','Yela','yeracto@gmail.com','Yahir.Ramirez1006326068','1006326068',NULL,1,'2025-12-02 11:42:16'),(4,'Yahir','Esteban','Ramirez','Yela','yeracto2@gmail.com','Yahir.Ramirez4','100000000',NULL,1,'2025-12-02 11:46:15'),(5,'prueba','','prueba dos','','prueba3@gmail.com','prueba.prueba dos5','1111111111',NULL,1,'2025-12-03 08:16:35'),(21,'prueba',NULL,'prueba dos',NULL,'prueba4@gmail.com','prueba.pruebados21','1111111121',NULL,1,'2025-12-04 11:06:26'),(22,'prueba',NULL,'tres',NULL,'asd@mgali.com','prueba.tres22','123123123',NULL,1,'2025-12-04 11:10:05'),(23,'a',NULL,'a',NULL,'a@a.com','a.a23','111111111',NULL,1,'2025-12-05 08:44:43');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_campus`
--

DROP TABLE IF EXISTS `user_campus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_campus` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `ID_USER` int NOT NULL,
  `ID_CAMPUS` int NOT NULL,
  `TOTAL_ACCESS` tinyint(1) DEFAULT '0',
  `ASSIGNED_AT` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_USER` (`ID_USER`,`ID_CAMPUS`),
  KEY `ID_CAMPUS` (`ID_CAMPUS`),
  CONSTRAINT `user_campus_ibfk_1` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `user_campus_ibfk_2` FOREIGN KEY (`ID_CAMPUS`) REFERENCES `campus` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_campus`
--

LOCK TABLES `user_campus` WRITE;
/*!40000 ALTER TABLE `user_campus` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_campus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `ID_USER` int NOT NULL,
  `ID_ROLE` int NOT NULL,
  PRIMARY KEY (`ID_USER`,`ID_ROLE`),
  KEY `ID_ROLE` (`ID_ROLE`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`ID_ROLE`) REFERENCES `role` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'control_access'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-05  0:16:39
