-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: cars
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `booking_date_from` varchar(255) DEFAULT NULL,
  `booking_date_to` varchar(255) DEFAULT NULL,
  `car_id` int NOT NULL,
  `customer_id` int NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `price_day` int NOT NULL,
  `total_price` double NOT NULL,
  PRIMARY KEY (`booking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (11,'2024-01-04','2024-01-05',4,1,'https://cdn.whichcar.com.au/assets/w_1536/b41f09a4/2023-tesla-cybertruck-rodeo-screen-shot-2022-04-08-at-13548-pm-2.jpg',500,500),(12,'2024-01-10','2024-01-17',1,1,'https://cdn.futura-sciences.com/cdn-cgi/image/width=1520,quality=50,format=auto/sources/images/actu/TeslaS_P100-D__1_.jpg',250,1750),(14,'2024-01-04','2024-01-04',5,1,'https://images.caradisiac.com/images/2/4/2/1/202421/S1-volvo-xc60-black-edition-81-630eur-pour-le-suv-hybride-rechargeable-de-luxe-756197.jpg',120,120),(16,'2024-01-04','2024-01-10',6,1,'https://www.auto-plus.tn/assets/modules/newcars/renault/clio/couverture/renault-clio.jpg',250,1500);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `car_id` int NOT NULL AUTO_INCREMENT,
  `car_image` varchar(255) DEFAULT NULL,
  `car_model` varchar(255) DEFAULT NULL,
  `car_name` varchar(255) DEFAULT NULL,
  `car_price` int NOT NULL,
  `car_status` bit(1) NOT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,'https://cdn.futura-sciences.com/cdn-cgi/image/width=1520,quality=50,format=auto/sources/images/actu/TeslaS_P100-D__1_.jpg','X','tesla',250,_binary '\0'),(2,'https://www.auto-plus.tn/assets/modules/newcars/renault/clio/couverture/renault-clio.jpg','clio','renault',100,_binary ''),(4,'https://cdn.whichcar.com.au/assets/w_1536/b41f09a4/2023-tesla-cybertruck-rodeo-screen-shot-2022-04-08-at-13548-pm-2.jpg','xxx','tesla',500,_binary '\0'),(5,'https://images.caradisiac.com/images/2/4/2/1/202421/S1-volvo-xc60-black-edition-81-630eur-pour-le-suv-hybride-rechargeable-de-luxe-756197.jpg','xc60','volvo',120,_binary '\0'),(6,'https://www.auto-plus.tn/assets/modules/newcars/renault/clio/couverture/renault-clio.jpg','206','peugeot',250,_binary '\0');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `customer_address` varchar(255) DEFAULT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `customer_first_name` varchar(255) DEFAULT NULL,
  `customer_last_name` varchar(255) DEFAULT NULL,
  `customer_phone` varchar(255) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(150) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `customer_password` varchar(255) DEFAULT NULL,
  `customer_user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'fouchena','helmi@gamil.com','Helmi','Rezgui','22222222','wael','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','user',NULL,NULL),(2,'fouchena','ghaith@gmail.com','ghaith','hammami','1111','helmi','admin','ADMIN','admin','helmi'),(3,'arg','leo','messi','leo','10101010',NULL,NULL,NULL,NULL,NULL),(4,'tunis','helmi@gmail.com','Helmi','hammami','111111',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-04 19:17:39
