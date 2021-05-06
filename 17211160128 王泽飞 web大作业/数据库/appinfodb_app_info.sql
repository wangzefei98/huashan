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
-- Table structure for table `app_info`
--

DROP TABLE IF EXISTS `app_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_info` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `softwareName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '软件名称',
  `APKName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'APK名称（唯一）',
  `supportROM` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '支持ROM',
  `interfaceLanguage` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '界面语言',
  `softwareSize` decimal(20,2) DEFAULT NULL COMMENT '软件大小（单位：M）',
  `updateDate` date DEFAULT NULL COMMENT '更新日期',
  `devId` bigint(30) DEFAULT NULL COMMENT '开发者id（来源于：dev_user表的开发者id）',
  `appInfo` varchar(5000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '应用简介',
  `status` bigint(30) DEFAULT NULL COMMENT '状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）',
  `onSaleDate` datetime DEFAULT NULL COMMENT '上架时间',
  `offSaleDate` datetime DEFAULT NULL COMMENT '下架时间',
  `flatformId` bigint(30) DEFAULT NULL COMMENT '所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）',
  `categoryLevel3` bigint(30) DEFAULT NULL COMMENT '所属三级分类（来源于：data_dictionary）',
  `downloads` bigint(30) DEFAULT NULL COMMENT '下载量（单位：次）',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于dev_user开发者信息表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于dev_user开发者信息表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  `categoryLevel1` bigint(30) DEFAULT NULL COMMENT '所属一级分类（来源于：data_dictionary）',
  `categoryLevel2` bigint(30) DEFAULT NULL COMMENT '所属二级分类（来源于：data_dictionary）',
  `logoPicPath` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'LOGO图片url路径',
  `logoLocPath` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'LOGO图片的服务器存储路径',
  `versionId` bigint(30) DEFAULT NULL COMMENT '最新的版本id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_info`
--

LOCK TABLES `app_info` WRITE;
/*!40000 ALTER TABLE `app_info` DISABLE KEYS */;
INSERT INTO `app_info` VALUES (48,'劲乐团U:O2Jam U','com.momocorp.o2jamu','2.3及更高版本','英文软件',56.00,NULL,1,'劲乐团U O2Jam U是一款音乐节拍游戏，跟着音乐的节奏点击屏幕即可，就是跳舞机，需要网络支持。\r\n注意：部分机型会卡死在启动界面或fc，结束进程后重新开启游戏就正常了。',1,NULL,NULL,3,38,1000,1,'2016-08-22 11:43:02',NULL,NULL,2,19,'/uploadfiles/com.katecca.screenofflockdonate.jpg','/uploadfiles/com.katecca.screenofflockdonate.jpg',NULL),(49,'LBE安全大师','com.lbe.security','2.2及更高版本','简体中文',9.00,NULL,1,'欢迎您使用LBE安全大师，Android平台上首款主动式防御软件，第一款具备实时监控与拦截能力的安全软件。\r\n安全大师基于业界首创的API拦截技术，能够实时监控与拦截系统中的敏感操作，动态拦截来自已知和未知的各种威胁。避免各类吸费软件，广告软件乃至木马病毒窃取您手机内的隐私信息以及可能产生的经济损失。\r\n安全大师同时提供了强大的定制功能与完善的提示机制，您更可以精确控制系统中每一个应用的权限，同时不放过任何一次可疑的操作。对于没有获取root权限的用户，您依旧可以使用我们的流量控制，电话短信防火墙，系统优化清理等功能。',1,NULL,NULL,1,32,2000,1,'2016-08-22 11:47:11',NULL,NULL,1,3,'/uploadfiles/air.net.machinarium.Machinarium.GP.jpg','/uploadfiles/air.net.machinarium.Machinarium.GP.jpg',NULL),(50,'应用锁:Smart App Protector','com.sp.protector.free','2.3及更高版本','简体中文',3.00,NULL,1,'Smart App Protector是一款应用锁定程序，可以实现当您打开某个应用时进行密码保护，从而保护用户的隐私问题。',1,NULL,NULL,1,32,5000,1,'2016-08-22 11:49:12',NULL,NULL,1,3,'/uploadfiles/air.net.machinarium.Machinarium.GP.jpg','/uploadfiles/air.net.machinarium.Machinarium.GP.jpg',NULL),(51,'谷歌拼音输入法','com.google.android.inputmethod.pinyin','4.2及更高版本','简体中文',16.00,NULL,1,'谷歌拼音输入法是一款专门用于输入中文的输入法，提供了多种方便的输入方式：\r\n- 全键盘拼音支持中文滑行输入和智能纠错\r\n- 9键键盘拼音支持中文滑行输入\r\n- 笔画键盘\r\n- 全屏和半屏手写键盘\r\n- 英文键盘\r\n- 模糊拼音\r\n- 双拼\r\n- 针对各种不同屏幕尺寸优化的UI布局\r\n- 语音输入\r\n不仅支持输入简体中文、繁体中文，还支持标点符号、表情符号、拉丁字符和数字。语音输入法使用基于互联网的语音识别服务，以提供高精度的输入匹配。\r\n\r\n注意：要在你的Android设备上使用该输入法，请在 “设置”→“语言和输入法”中开启。\r\n\r\n如需输入粤语，请下载谷歌粤语输入法\r\nhttps://play.google.com/store/apps/details?id=com.google.android.apps.inputmethod.cantonese\r\n\r\n如需使用注音或者倉頡输入繁体中文，请下载谷歌注音输入法\r\nhttps://play.google.com/store/apps/details?id=com.google.android.apps.inputmethod.zhuyin',1,NULL,NULL,3,29,8000,1,'2016-08-22 11:53:23',NULL,NULL,1,3,'/uploadfiles/air.net.machinarium.Machinarium.GP.jpg','/uploadfiles/air.net.machinarium.Machinarium.GP.jpg',37),(52,'RE管理器:Root Explorer','com.speedsoftware.rootexplorer','2.3及更高版本','简体中文',3.00,NULL,1,'RootExplorer 需要 ROOT 权限，新建文件夹，查看 / 编辑文件，软件安装，RootExplorer 具备普通文件管理器的各项基本功能，另外还添加了搜索功能，在手机上找东西变得更加方便。此外，RootExplorer 最大的特点在于它能够删除手机中自带的应用程序，如 GOOGLEMAP,CONTACTS,MARKET,GTALK 等等。',2,NULL,NULL,1,30,2340,1,'2016-08-22 11:55:14',NULL,NULL,1,3,'/uploadfiles/air.net.machinarium.Machinarium.GP.jpg','/uploadfiles/air.net.machinarium.Machinarium.GP.jpg',38),(53,'关屏锁定:Screen Off and Lock','com.katecca.screenofflockdonate','2.2及更高版本','简体中文',1.00,NULL,1,'关屏锁定Screen Off and Lock能实现只需点击一下即可关闭屏幕及锁定手机，支持设定关屏动画及音效 ，不是widget，可以放在任何地方，同时支持通知栏激活或者长按搜索键激活。',1,NULL,NULL,1,37,20,1,'2016-08-22 13:07:11',NULL,NULL,1,4,'/uploadfiles/air.net.machinarium.Machinarium.GP.jpg','/uploadfiles/air.net.machinarium.Machinarium.GP.jpg',NULL),(54,'重力锁屏:Gravity Screen Off Pro','com.plexnor.gravityscreenoffpro','2.2及更高版本','英文软件',1.00,NULL,1,'重力锁屏Gravity Screen Off Pro可以让手机在特定的条件下自动开启/关闭屏幕（例如放入口袋、放在桌面上、在传感器前挥手、移动手机等），而且识别度相当准确，你可以在设置中随意设置任意角度，当你把手机按这个角度（或者比这个角度小）放入口袋、桌面上时，屏幕就会自动关闭。日常使用起来节省了不少手动开屏/关屏的时间，这个才是真正的与科技接轨！\r\n功能说明：\r\n* 支持识别手机是否在口袋中，可以自定义在口袋中识别设备放置的角度、方向；\r\n* 支持识别手机是否在桌面上，可以自定义在桌面上识别设备放置的角度；\r\n* 识别设备正面、反面放置；\r\n* 可以是使用距离传感器、重力传感器进行识别；\r\n* 可以通过识别动作（例如挥手、移动手机等）来开启/关闭屏幕）；\r\n* 可以自定识别灵敏度；\r\n* 支持在插入而且后启用传感器来自动开启/关闭屏幕；\r\n* 支持开机自动启用服务；\r\n* 可以在通知栏显示启用/停用服务的快捷方式。',1,NULL,NULL,1,37,23,1,'2016-08-22 13:08:24',NULL,NULL,1,4,'/uploadfiles/air.net.machinarium.Machinarium.GP.jpg','/uploadfiles/air.net.machinarium.Machinarium.GP.jpg',NULL),(55,'机械迷城:Machinarium','air.net.machinarium.Machinarium.GP','2.3及更高版本','英文软件',11.00,NULL,1,'机械迷城Machinarium是一款解密冒险游戏，玩家可以在城市里随意的走动，跟场景或是其他同样是机器人互动，了解他们的需求以及帮忙他们，一步一步往事件的核心探索。 ',3,NULL,NULL,1,43,277,1,'2016-08-22 13:09:44',NULL,NULL,2,20,'/uploadfiles/air.net.machinarium.Machinarium.GP.jpg','/uploadfiles/air.net.machinarium.Machinarium.GP.jpg',36),(56,'Dont Starve饥荒','com.kleientertainment.doNotStarvePocket','4.0.3及更高版本','英文软件',4.00,NULL,1,'Don`t Starve: Pocket Edition移动版将深受超过4百万玩家喜爱的热门PC游戏移植到了安卓平台。现在你可以随时随地进入充满科学和魔法元素的世界，体验原汁原味的荒野生存游戏！\r\n你扮演威尔逊，一位被困住并传送到神秘荒野世界的勇敢无畏的绅士科学家。如果威尔逊希望逃出生天并找到回家的路，他必须充分利用所处的环境及这里的各种生物。\r\n进入一个光怪陆离而未经探索的世界，这里充满了奇怪的生物以及形形色色的危险和意外。收集资源以制作符合你的生存风格的物品和建筑。一路解开这块奇怪大陆上的各种谜团。',4,NULL,'2020-06-30 14:30:10',2,41,390,1,'2016-08-22 13:11:51',1,NULL,2,19,'/uploadfiles/air.net.machinarium.Machinarium.GP.jpg','/uploadfiles/air.net.machinarium.Machinarium.GP.jpg',42),(57,'机械世界:Apparatus','com.bithack.apparatus','1.6及更高版本','英文软件',11.00,NULL,1,'                  <span>                  <span>在机械世界Apparatus游戏中你需要利用木板、钉子、绳索、圆轮等等各种道具搭建从简单到复杂的机械结构，使得小球可以最终滚落到蓝色方框中。可以利用的可不止重力，包括杠杆原理、滑轮等等，尤其是后面的关卡，你需要足够灵活的头脑才能解决问题，可玩性还是非常高的。</span></span>',3,NULL,NULL,1,43,255,1,'2016-08-22 13:13:27',1,'2020-06-18 16:10:40',2,20,'/uploadfiles/air.net.machinarium.Machinarium.GP.jpg','/uploadfiles/air.net.machinarium.Machinarium.GP.jpg',41),(58,'沙盘玩具:The Powder Toy','com.doodleapps.powdertoy','2.2及更高版本','英文软件',1.00,NULL,1,'沙盘玩具The Powder Toy是一款模拟类游戏。想过自己建造核电站吗？或者自己做一个CPU？你甚至可以创建一个虚拟网络。沙盘玩具可以模拟空气的压力，速度，热，重力和无数的不同物质之间的相互作用，游戏提供各种形态的建材，用以构建复杂的机器或是电子元件，你可以模拟超酷的爆炸或是布线出复杂的机器人。欢迎提交您的作品。',4,NULL,'2016-08-22 13:27:42',3,44,2000,1,'2016-08-22 13:14:56',1,NULL,2,20,'/uploadfiles/air.net.machinarium.Machinarium.GP.jpg','/uploadfiles/air.net.machinarium.Machinarium.GP.jpg',40),(72,'wzf','123456ppp','123','English',1.00,NULL,1,'                  <span>12</span>',1,NULL,NULL,1,29,1,1,'2020-06-19 09:49:10',1,'2020-06-19 12:25:49',1,3,'/uploadfiles/com.katecca.screenofflockdonate.jpg','C:\\Users\\MAC\\Desktop\\JAVA-WEB\\uploads\\uploadfiles\\com.katecca.screenofflockdonate.jpg',NULL);
/*!40000 ALTER TABLE `app_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-30 21:54:03
