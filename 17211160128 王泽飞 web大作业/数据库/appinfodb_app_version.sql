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
-- Table structure for table `app_version`
--

DROP TABLE IF EXISTS `app_version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_version` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `appId` bigint(30) DEFAULT NULL COMMENT 'appId（来源于：app_info表的主键id）',
  `versionNo` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '版本号',
  `versionInfo` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '版本介绍',
  `publishStatus` bigint(30) DEFAULT NULL COMMENT '发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）',
  `downloadLink` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '下载链接',
  `versionSize` decimal(20,2) DEFAULT NULL COMMENT '版本大小（单位：M）',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于dev_user开发者信息表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于dev_user开发者信息表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  `apkLocPath` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'apk文件的服务器存储路径',
  `apkFileName` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '上传的apk文件名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_version`
--

LOCK TABLES `app_version` WRITE;
/*!40000 ALTER TABLE `app_version` DISABLE KEYS */;
INSERT INTO `app_version` VALUES (33,58,'V1.1.1','V1.1.1版本简介',3,'/AppInfoSystem/statics/uploadfiles/com.doodleapps.powdertoy-V1.1.31.apk',1.00,1,'2016-08-22 13:17:47',NULL,NULL,'D:\\soft\\apache-tomcat-7.0.41\\webapps\\AppInfoSystem\\statics\\uploadfiles\\com.doodleapps.powdertoy-V1.1.31.apk','com.doodleapps.powdertoy-V1.1.31.apk'),(34,57,'V1.1.1','              V1.1.1版本简介',3,'/AppInfoSystem/statics/uploadfiles/com.bithack.apparatus-V1.1.1.apk',11.00,1,'2016-08-22 13:19:42',1,'2016-08-22 13:19:54','D:\\soft\\apache-tomcat-7.0.41\\webapps\\AppInfoSystem\\statics\\uploadfiles\\com.bithack.apparatus-V1.1.1.apk','com.bithack.apparatus-V1.1.1.apk'),(35,56,'V1.1.1','              V1.1.1简介',2,'/AppInfoSystem/statics/uploadfiles/com.kleientertainment.doNotStarvePocket-V1.1.1.apk',4.00,1,'2016-08-22 13:21:12',1,'2016-08-22 13:28:07','D:\\soft\\apache-tomcat-7.0.41\\webapps\\AppInfoSystem\\statics\\uploadfiles\\com.kleientertainment.doNotStarvePocket-V1.1.1.apk','com.kleientertainment.doNotStarvePocket-V1.1.1.apk'),(36,55,'V1.1.1','              V1.1.1简介',3,'/AppInfoSystem/statics/uploadfiles/air.net.machinarium.Machinarium.GP-V1.1.1.apk',11.00,1,'2016-08-22 13:21:40',1,'2016-08-22 13:21:57','D:\\soft\\apache-tomcat-7.0.41\\webapps\\AppInfoSystem\\statics\\uploadfiles\\air.net.machinarium.Machinarium.GP-V1.1.1.apk','air.net.machinarium.Machinarium.GP-V1.1.1.apk'),(37,51,'V1.1.1','V1.1.1简介',3,'/AppInfoSystem/statics/uploadfiles/com.google.android.inputmethod.pinyin-V1.1.1.apk',16.00,1,'2016-08-22 13:24:07',NULL,NULL,'D:\\soft\\apache-tomcat-7.0.41\\webapps\\AppInfoSystem\\statics\\uploadfiles\\com.google.android.inputmethod.pinyin-V1.1.1.apk','com.google.android.inputmethod.pinyin-V1.1.1.apk'),(38,52,'V1.1.1','V1.1.1简介',3,'/AppInfoSystem/statics/uploadfiles/com.speedsoftware.rootexplorer-V1.1.1.apk',3.00,1,'2016-08-22 13:24:35',NULL,NULL,'D:\\soft\\apache-tomcat-7.0.41\\webapps\\AppInfoSystem\\statics\\uploadfiles\\com.speedsoftware.rootexplorer-V1.1.1.apk','com.speedsoftware.rootexplorer-V1.1.1.apk'),(39,58,'V1.1.2','V1.1.2',3,'/AppInfoSystem/statics/uploadfiles/com.doodleapps.powdertoy-V1.1.2.apk',2.00,1,'2016-08-22 13:26:15',NULL,NULL,'D:\\soft\\apache-tomcat-7.0.41\\webapps\\AppInfoSystem\\statics\\uploadfiles\\com.doodleapps.powdertoy-V1.1.2.apk','com.doodleapps.powdertoy-V1.1.2.apk'),(40,58,'V1.1.3','V1.1.3简介',2,'/AppInfoSystem/statics/uploadfiles/com.doodleapps.powdertoy-V1.1.3.apk',2.00,1,'2016-08-22 13:26:47',1,'2016-08-22 13:27:42','D:\\soft\\apache-tomcat-7.0.41\\webapps\\AppInfoSystem\\statics\\uploadfiles\\com.doodleapps.powdertoy-V1.1.3.apk','com.doodleapps.powdertoy-V1.1.3.apk'),(41,57,'V1.1.2','              V1.1.2简介',3,'/AppInfoSystem/statics/uploadfiles/com.bithack.apparatus-V1.1.2.apk',12.00,1,'2016-08-22 13:27:32',1,'2020-06-18 21:06:52','D:\\soft\\apache-tomcat-7.0.41\\webapps\\AppInfoSystem\\statics\\uploadfiles\\com.bithack.apparatus-V1.1.2.apk','com.bithack.apparatus-V1.1.2.apk'),(42,56,'V1.1.2','V1.1.2简介',2,'/AppInfoSystem/statics/uploadfiles/com.kleientertainment.doNotStarvePocket-V1.1.2.apk',4.00,1,'2016-08-22 15:00:32',1,'2020-06-30 14:30:10','D:\\soft\\apache-tomcat-7.0.41\\webapps\\AppInfoSystem\\statics\\uploadfiles\\com.kleientertainment.doNotStarvePocket-V1.1.2.apk','com.kleientertainment.doNotStarvePocket-V1.1.2.apk');
/*!40000 ALTER TABLE `app_version` ENABLE KEYS */;
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
