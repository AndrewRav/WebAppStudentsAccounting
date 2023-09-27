-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: studentdb
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `last_name` varchar(250) NOT NULL,
  `first_name` varchar(250) NOT NULL,
  `middle_name` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `status` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'qwe','qwe123','Рябицкий','Андрей','Викторович','qwe@gmail.com','user'),(2,'asd','asd','Кунсманайте','Эвелина','Арвидасовна','asd@gmail.com','admin'),(3,'zxc','zxc','Рябицкий','Андрей','Викторович','zxc@gmail.com','admin'),(4,'max','zxc','Киселёв','Максим','Русланович','rty@gmail.com','user'),(7,'zxc','zxc','Рябицкая','Людмила','Михайловна','ludmila@gmail.com','user'),(8,'q','q','q','q','q','q@gmail.com','user'),(9,'w','w','w','w','w','w@gmail.com','user'),(11,'Vasya','1','Вася','Вася','Вася','vasya@gmail.com','user'),(12,'dsadsa','das','das','das','asdasd','asdasdaad@gmail.com','user'),(13,'Andrew','Andrew','Andrew','Andrew','Andrew','andrew@gmail.com','user'),(15,'qweqwe','qweqwe','qweqwe','qweqwe','qweqwe','qweqweqw@gmail.com','user'),(17,'qweqwe','dadsa','dqweqwe','qdwqdwq','dasda','qwewqewqe@gmail.com','user'),(19,'Vasya','Vasya','Vasya','Vasya','Vasya','VasyaVasya@gmail.com','user'),(25,'Andrew','Andrew','Andrew','Andrew','Andrew','qweqw@gmail.com','user'),(27,'Andrew','Andrew','Andrew','Andrew','Andrew','andrewdas@gmail.com','user'),(30,'Andrew','Andrew','Andrew','Andrew','Andrew','Andrdwqdqwew@gmail.com','user'),(117,'dsa','dsa','dsa','dsa','dsa','dsadwqedq@gmail.com','user'),(118,'Lina','Lina','Lina','Lina','Lina','Lina@gmail.com','user'),(120,'qwe123','qwe123','Рябицкий','Андрей','Викторович','qwe123@gmail.com','user');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-27 10:44:50
