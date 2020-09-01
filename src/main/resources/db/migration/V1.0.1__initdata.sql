/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.7.21 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Data for the table `permission` */

insert  into `permission`(`id`,`parentid`,`level`,`mark`,`description`,`status`,`type`,`action`,`updatetime`,`createtime`,`createperson`) values  
(1,0,1,'W_M_XTGL','系统',1,1,NULL,NULL,NULL,NULL),
(2,1,2,'W_M_XTZHGL','系统账户管理',1,1,NULL,NULL,NULL,NULL),
(3,2,3,'W_M_XTZHTJ','账户添加',1,1,NULL,NULL,NULL,NULL),
(4,2,3,'W_F_XTZHSC','账户删除',1,1,NULL,NULL,NULL,NULL),
(5,2,3,'W_F_XTZHXG','账户修改',1,1,NULL,NULL,NULL,NULL),
(6,2,3,'W_M_XTZHYL','账户一览',1,1,NULL,NULL,NULL,NULL),
(7,1,2,'W_M_XTJSGL','角色管理',1,1,NULL,NULL,NULL,NULL),
(8,7,3,'W_M_JSTJ','角色添加',1,1,NULL,NULL,NULL,NULL),
(9,7,3,'W_F_JSSC','角色删除',1,1,NULL,NULL,NULL,NULL),
(10,7,3,'W_F_JSXG','角色更新',1,1,NULL,NULL,NULL,NULL),
(11,7,3,'W_M_JSYL','角色一览',1,1,NULL,NULL,NULL,NULL);


/*Data for the table `role` */

insert  into `role`(`id`,`rolename`,`type`,`level`,`updatetime`,`createtime`,`createperson`) values 
(1,'超级管理员',1,2,NULL,NULL,NULL),
(2,'普通管理员',1,1,NULL,NULL,NULL);

/*Data for the table `rolepermission` */

insert  into `rolepermission`(`id`,`roleid`,`permissionid`,`updatetime`,`createtime`,`createperson`) values 
(1,1,1,NULL,NULL,NULL),
(2,1,2,NULL,NULL,NULL),
(3,1,3,NULL,NULL,NULL),
(4,1,4,NULL,NULL,NULL),
(5,1,5,NULL,NULL,NULL),
(6,1,6,NULL,NULL,NULL),
(7,1,7,NULL,NULL,NULL),
(8,1,8,NULL,NULL,NULL),
(9,1,9,NULL,NULL,NULL),
(10,1,10,NULL,NULL,NULL),
(11,1,11,NULL,NULL,NULL);

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`salt`,`mail`,`phone`,`status`,`type`,`updatetime`,`createtime`,`createperson`) values 
(1,'admin','01abaeee604db96525f78e63e4043d9e','d1b0d26883','xingh@kotei-info.com',NULL,1,2,NULL,NULL,NULL);

/*Data for the table `userrole` */

insert  into `userrole`(`id`,`userid`,`roleid`,`updatetime`,`createtime`,`createperson`) values 
(1,1,1,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
