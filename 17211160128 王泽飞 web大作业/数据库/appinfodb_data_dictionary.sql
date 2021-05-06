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
-- Table structure for table `data_dictionary`
--

DROP TABLE IF EXISTS `data_dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_dictionary` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `typeCode` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型编码',
  `typeName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型名称',
  `valueId` bigint(30) DEFAULT NULL COMMENT '类型值ID',
  `valueName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型值Name',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=111 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_dictionary`
--

LOCK TABLES `data_dictionary` WRITE;
/*!40000 ALTER TABLE `data_dictionary` DISABLE KEYS */;
INSERT INTO `data_dictionary` VALUES (1,'USER_TYPE','用户类型',1,'超级管理员',1,'2016-08-16 20:11:47',1,'2020-06-25 13:40:40'),(2,'USER_TYPE','用户类型',2,'财务',1,'2016-08-13 08:11:47',1,'2020-06-22 16:02:22'),(3,'USER_TYPE','用户类型',3,'市场',1,'2016-08-12 18:11:47',NULL,NULL),(4,'USER_TYPE','用户类型',4,'运营',1,'2016-08-12 18:11:47',NULL,NULL),(5,'USER_TYPE','用户类型',5,'销售',1,'2016-08-13 22:11:47',1,'2020-06-22 16:02:28'),(6,'APP_STATUS','APP状态',1,'待审核',1,'2016-08-12 18:11:47',NULL,NULL),(7,'APP_STATUS','APP状态',2,'审核通过',1,'2016-08-12 18:11:47',NULL,NULL),(8,'APP_STATUS','APP状态',3,'审核未通过',1,'2016-08-12 18:11:47',NULL,NULL),(9,'APP_STATUS','APP状态',4,'已上架',1,'2016-08-12 18:11:47',NULL,NULL),(10,'APP_STATUS','APP状态',5,'已下架',1,'2016-08-12 18:11:47',NULL,NULL),(11,'APP_FLATFORM','所属平台',1,'手机',1,'2016-08-12 18:11:47',NULL,NULL),(12,'APP_FLATFORM','所属平台',2,'平板',1,'2016-08-12 18:11:47',NULL,NULL),(14,'PUBLISH_STATUS','发布状态',1,'不发布',1,'2016-08-12 18:11:47',NULL,NULL),(15,'PUBLISH_STATUS','发布状态',2,'已发布',1,'2016-08-12 18:11:47',NULL,NULL),(16,'PUBLISH_STATUS','发布状态',3,'预发布',1,'2016-08-12 18:11:47',NULL,NULL),(13,'APP_FLATFORM','所属平台',3,'通用',1,'2016-08-12 18:11:47',NULL,NULL),(110,'type','用户',NULL,'qwer',1,'2020-06-24 20:29:01',NULL,NULL);
/*!40000 ALTER TABLE `data_dictionary` ENABLE KEYS */;
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
