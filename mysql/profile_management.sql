-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: profile_management
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `creditprofile`
--

DROP TABLE IF EXISTS `creditprofile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creditprofile` (
  `ProfileID` int NOT NULL AUTO_INCREMENT,
  `FullName` varchar(255) NOT NULL,
  `DateOfBirth` date NOT NULL,
  `IdentityNumber` varchar(50) NOT NULL,
  `PermanentAddress` varchar(500) DEFAULT NULL,
  `PhoneNumber` varchar(50) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `MonthlyIncome` decimal(20,2) DEFAULT NULL,
  `IncomeSource` varchar(255) DEFAULT NULL,
  `TotalAssets` decimal(20,2) DEFAULT NULL,
  `TotalLiabilities` decimal(20,2) DEFAULT NULL,
  `CurrentCreditCardsOrLoans` int DEFAULT NULL,
  `CompanyName` varchar(255) DEFAULT NULL,
  `Occupation` varchar(255) DEFAULT NULL,
  `JobPosition` varchar(100) DEFAULT NULL,
  `JobDurationInMonths` int DEFAULT NULL,
  `GuarantorName` varchar(255) DEFAULT NULL,
  `GuarantorRelationship` varchar(50) DEFAULT NULL,
  `GuarantorPhone` varchar(50) DEFAULT NULL,
  `GuarantorEmail` varchar(100) DEFAULT NULL,
  `PaymentDeadline` date DEFAULT NULL,
  PRIMARY KEY (`ProfileID`),
  UNIQUE KEY `IdentityNumber` (`IdentityNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditprofile`
--

LOCK TABLES `creditprofile` WRITE;
/*!40000 ALTER TABLE `creditprofile` DISABLE KEYS */;
INSERT INTO `creditprofile` VALUES (7,'Bob Brown','1987-04-04','ID0004','126 Main St','123-456-7893','bob@example.com',7500.00,'Sales',130000.00,3500.00,4,'Trade Corp','Salesman','Entry',6,'Alice Adams','Colleague','123-456-7892','alice@example.com','2023-10-04'),(10,'Eva Edwards','1991-07-07','ID0007','129 Main St','123-456-7896','eva@example.com',9000.00,'Medicine',160000.00,5000.00,7,'Med Corp','Doctor','Specialist',48,'Frank Franklin','Nurse','123-456-7897','frank@example.com','2023-10-07'),(12,'Grace Green','1983-09-09','ID0009','131 Main St','123-456-7898','grace@example.com',10000.00,'Business',180000.00,6000.00,9,'Biz Corp','CEO','Top',120,'Hank Hill','Assistant','123-456-7899','hank@example.com','2023-10-09'),(13,'Hank Hill','1986-10-10','ID0010','132 Main St','123-456-7899','hank@example.com',11000.00,'Oil',190000.00,6500.00,10,'Oil Corp','Rig Worker','Driller',84,'Ivy Ingrid','Drill Assistant','123-456-7800','ivy@example.com','2023-10-10'),(14,'Ivy Ingrid','1993-11-11','ID0011','133 Main St','123-456-7800','ivy@example.com',12000.00,'Journalism',200000.00,7000.00,11,'News Corp','Journalist','Reporter',36,'Jack Jackson','Editor','123-456-7801','jack@example.com','2023-10-11'),(15,'Jack Jackson','1994-12-12','ID0012','134 Main St','123-456-7801','jack@example.com',12500.00,'Farming',210000.00,7500.00,12,'Agri Corp','Farmer','Cattle',60,'Kara Kennedy','Vet','123-456-7802','kara@example.com','2023-10-12'),(17,'Larry Lively','1979-02-14','ID0014','136 Main St','123-456-7803','larry@example.com',13500.00,'Transport',230000.00,8500.00,14,'Logi Corp','Driver','Truck',36,'Mara Morris','Loader','123-456-7804','mara@example.com','2023-10-14'),(18,'Mara Morris','1978-03-15','ID0015','137 Main St','123-456-7804','mara@example.com',14000.00,'Real Estate',240000.00,9000.00,15,'Estate Corp','Agent','Residential',24,'Nina Norris','Home Owner','123-456-7805','nina@example.com','2023-10-15'),(19,'Nina Norris','1982-04-16','ID0016','138 Main St','123-456-7805','nina@example.com',14500.00,'Construction',250000.00,9500.00,16,'Build Corp','Builder','General',12,'Oscar Oswald','Engineer','123-456-7806','oscar@example.com','2023-10-16'),(20,'Oscar Oswald','1981-05-17','ID0017','139 Main St','123-456-7806','oscar@example.com',15000.00,'Hospitality',260000.00,10000.00,17,'Hotel Corp','Chef','Head',60,'Patty Peterson','Waitress','123-456-7807','patty@example.com','2023-10-17'),(21,'Patty Peterson','1977-06-18','ID0018','140 Main St','123-456-7807','patty@example.com',15500.00,'Entertainment',270000.00,10500.00,18,'Cinema Corp','Director','Film',72,'Quincy Quill','Actor','123-456-7808','quincy@example.com','2023-10-18'),(22,'Quincy Quill','1976-07-19','ID0019','141 Main St','123-456-7808','quincy@example.com',16000.00,'Banking',280000.00,11000.00,19,'Bank Corp','Teller','Front Desk',24,'Rita Ross','Manager','123-456-7809','rita@example.com','2023-10-19');
/*!40000 ALTER TABLE `creditprofile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_param`
--

DROP TABLE IF EXISTS `system_param`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `system_param` (
  `param_key` varchar(45) NOT NULL,
  `param_group` varchar(45) NOT NULL,
  `param_value` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`param_key`,`param_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_param`
--

LOCK TABLES `system_param` WRITE;
/*!40000 ALTER TABLE `system_param` DISABLE KEYS */;
INSERT INTO `system_param` VALUES ('server','Schedule_Mail','0 30 11 * * ?',NULL);
/*!40000 ALTER TABLE `system_param` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-25 10:29:57
