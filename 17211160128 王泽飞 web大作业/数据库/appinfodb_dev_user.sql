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
-- Table structure for table `dev_user`
--

DROP TABLE IF EXISTS `dev_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dev_user` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `devCode` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者帐号',
  `devName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者名称',
  `devPassword` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者密码',
  `devEmail` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者电子邮箱',
  `devInfo` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者简介',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  `status` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dev_user`
--

LOCK TABLES `dev_user` WRITE;
/*!40000 ALTER TABLE `dev_user` DISABLE KEYS */;
INSERT INTO `dev_user` VALUES (1,'test001','测试账户001','123456','test001','123',1,'2016-08-21 04:13:41',1,'2020-06-21 10:12:41','审核通过'),(2,'admin','admin1','123456','admin',NULL,1,'2016-08-21 18:13:41',2,'2020-06-25 13:45:09','审核通过'),(3,'test0012','wzf','123456','123','test001',1,'2020-06-20 12:45:52',1,'2020-06-20 19:13:31','审核通过'),(5,'test','1','123456','123','12',1,NULL,NULL,NULL,'审核未通过'),(6,'test0012','1','123456','1','504157333@qq.com',2,'2020-06-25 12:59:35',NULL,NULL,'审核未通过'),(7,'test001213','1','123456','123','504157333@qq.com',2,'2020-06-25 13:23:24',NULL,NULL,'审核通过'),(8,'test0012','wzf','123456','1','504157333@qq.com',2,'2020-06-25 13:44:52',NULL,NULL,'审核通过');
/*!40000 ALTER TABLE `dev_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-30 21:54:02
