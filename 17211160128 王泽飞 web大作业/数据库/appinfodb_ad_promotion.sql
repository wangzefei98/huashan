-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: appinfodb
-- ------------------------------------------------------
-- Server version	5.6.32-log

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
-- Table structure for table `ad_promotion`
--

DROP TABLE IF EXISTS `ad_promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ad_promotion` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `appId` bigint(30) DEFAULT NULL COMMENT 'appId（来源于：app_info表的主键id）',
  `adPicPath` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '广告图片存储路径',
  `adPV` bigint(50) DEFAULT NULL COMMENT '广告点击量',
  `carouselPosition` int(30) DEFAULT NULL COMMENT '轮播位（1-n）',
  `startTime` datetime DEFAULT NULL COMMENT '起效时间',
  `endTime` datetime DEFAULT NULL COMMENT '失效时间',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ad_promotion`
--

LOCK TABLES `ad_promotion` WRITE;
/*!40000 ALTER TABLE `ad_promotion` DISABLE KEYS */;
INSERT INTO `ad_promotion` VALUES (1,48,'/uploadfiles/com.katecca.screenofflockdonate.jpg',100,10,'2020-06-01 14:00:00','2020-06-30 14:00:00',1,'2020-06-01 14:00:00',1,'2020-06-22 21:48:42'),(2,48,'/uploadfiles/com.katecca.screenofflockdonate.jpg',1,2,'2020-06-01 00:00:00','2020-06-07 00:00:00',1,'2020-06-27 20:34:09',NULL,NULL);
/*!40000 ALTER TABLE `ad_promotion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-30 21:54:04
