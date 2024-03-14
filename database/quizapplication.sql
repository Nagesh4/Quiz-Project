CREATE DATABASE  IF NOT EXISTS `quizapplication` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `quizapplication`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: quizapplication
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `question_title` varchar(255) NOT NULL,
  `option1` varchar(50) NOT NULL,
  `option2` varchar(50) NOT NULL,
  `option3` varchar(50) NOT NULL,
  `option4` varchar(50) NOT NULL,
  `right_answer` varchar(50) NOT NULL,
  `difficult_level` varchar(15) NOT NULL,
  `category` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'Who developed Python Programming Language?','Wick van Rossum','Rasmus Lerdorf','Guido van Rossum','Niene Stom\n','Guido van Rossum','easy','Python'),(2,'Is Python case sensitive when dealing with identifiers?','no','yes','machine dependent','machine independent','yes','easy','Python'),(3,'Which type of Programming does Python support?','object-oriented programming','structured programming','functional programming','all of the mentioned','all of the mentioned','easy','Python'),(5,'Which one is NOT a legal variable name?','_myvar','my-var','my_var','Myvar','my-var','medium','Python'),(6,'Name the python module which supports regular expressions?','regex','re','pyre','pyregex','re','medium','Python'),(7,'Pylab is a package that combine _______,________&______ into a single namespace?','Numpy, scipy & matplotlib','Numpy, matplotlib & pandas','Numpy, pandas & matplotlib','Numpy, scipy & pandas','Numpy, scipy & matplotlib','medium','Python'),(8,'Which of the following is the use of id() function in python?','Id returns the identity of the object','Every object doesn’t have a unique id','All of the mentioned','None of the mentioned','Id returns the identity of the object','hard','Python'),(9,'Which one of the following have the same precedence?','Addition and Subtraction','Multiplication and Division','Both the options','None of the options','Both the options','hard','Python'),(10,'Suppose s is “		World\n”, what is s.strip() ?','		World\n','	World\n','		WORLD\n','World','World','hard','Python'),(12,'How do you insert COMMENTS in Java code?','// This is a comment','/* This is a comment','# This is a comment','None of the above','// This is a comment','easy','Java'),(13,'Which data type is used to create a variable that should store text?','String','myString','string','Txt','String','easy','Java'),(14,'Which keyword is used to return a value inside a method?','return','break','get','void','return','medium','Java'),(15,'Which method can be used to find the highest value of x and y?','Math.max(x,y)','Math.maxNum(x,y)','Math.maximum(x,y)','Math.largest(x,y)','Math.max(x,y)','medium','Java'),(16,'Which method can be used to return a string in upper case letters?','toUpperCase()','upperCase()','tuc()','touppercase()','toUpperCase()','medium','Java'),(17,'Which of those doesn’t have an index based structure?','List','Set','Map','All of above','Set','hard','Java'),(18,'java.util.Collections is a:','Class','Interface','Object','None of the above','Class','hard','Java'),(19,'Methods such as reverse, shuffle are offered in:','Object','Collection','Collections','Apache Commons Collections','Collections','hard','Java'),(20,'What do ‘R’ and ‘E’ mean in  ‘REPL’','Run and Enter','Run and Execute','Read and Enter','Read and Execute','Read and Execute','medium','Python'),(21,'Which method can be used to find the length of a string?','getSize()','len()','getLength()','length()','length()','medium','Java'),(22,'Is Python code compiled or interpreted?','Python code is both compiled and interpreted','Python code is neither compiled nor interpreted','Python code is only compiled','Python code is only interpreted','Python code is both compiled and interpreted','easy','Python'),(24,'Which environment variable is used to set the java path?','MAVEN_Path','JavaPATH','JAVA','JAVA_HOME','JAVA_HOME','easy','Java');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-12 21:18:13
