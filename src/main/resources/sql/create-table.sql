/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.18 : Database - materials_need_plan_manage
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`materials_need_plan_manage` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `materials_need_plan_manage`;

/*Table structure for table `department_role_relation_t` */

DROP TABLE IF EXISTS `department_role_relation_t`;

CREATE TABLE `department_role_relation_t` (
  `id` int(200) NOT NULL AUTO_INCREMENT COMMENT '关系ID',
  `department_id` int(200) DEFAULT NULL COMMENT '部门ID',
  `role_id` int(200) DEFAULT NULL COMMENT '角色ID',
  `creater_by` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `department_role_relation_t` */

/*Table structure for table `department_t` */

DROP TABLE IF EXISTS `department_t`;

CREATE TABLE `department_t` (
  `id` int(200) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `department_code` int(200) DEFAULT NULL COMMENT '部门编号',
  `department_name` varchar(2000) DEFAULT NULL COMMENT '部门名称',
  `parent_id` int(200) DEFAULT NULL COMMENT '父节点id',
  `department_level` int(200) DEFAULT NULL COMMENT '部门级别',
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `department_t` */

/*Table structure for table `hi_task_t` */

DROP TABLE IF EXISTS `hi_task_t`;

CREATE TABLE `hi_task_t` (
  `id` int(200) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `business_key` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务主键',
  `proc_inst_id` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '实例id',
  `task_to` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务处理人',
  `assignee` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务提交人',
  `parent_id` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父流程id',
  `task_name` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务名称',
  `is_agree` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否通过1同意2驳回',
  `creater_by` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程任务历史轨迹表';

/*Data for the table `hi_task_t` */

/*Table structure for table `materials_need_t` */

DROP TABLE IF EXISTS `materials_need_t`;

CREATE TABLE `materials_need_t` (
  `id` int(200) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '需求标题',
  `materials_sort` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '物料类别',
  `materials_code` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '物料编码',
  `need_count` int(20) DEFAULT NULL COMMENT '需求数量',
  `need_date` datetime DEFAULT NULL COMMENT '需求日期',
  `need_unit` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '需求单位',
  `technical_parameters` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '技术参数',
  `remark` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `creater_by` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `materials_need_t` */

/*Table structure for table `role_t` */

DROP TABLE IF EXISTS `role_t`;

CREATE TABLE `role_t` (
  `id` int(200) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名',
  `role_code` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色编码',
  `creater_by` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_t` */

/*Table structure for table `ru_task_t` */

DROP TABLE IF EXISTS `ru_task_t`;

CREATE TABLE `ru_task_t` (
  `id` int(200) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `business_key` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务主键',
  `proc_inst_id` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '实例id',
  `task_to` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务处理人',
  `assignee` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务提交人',
  `task_name` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务名称',
  `is_agree` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否通过1同意2驳回',
  `creater_by` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ru_task_t` */

/*Table structure for table `task_todo_t` */

DROP TABLE IF EXISTS `task_todo_t`;

CREATE TABLE `task_todo_t` (
  `id` int(200) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `assignee` int(200) DEFAULT NULL COMMENT '任务发起人',
  `task_to` int(200) DEFAULT NULL COMMENT '任务处理人',
  `business_key` int(200) DEFAULT NULL COMMENT '业务主键',
  `task_statue` int(20) DEFAULT NULL COMMENT '任务状态',
  `task_title` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务标题',
  `todo_remark` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '处理意见',
  `creater_by` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `task_todo_t` */

/*Table structure for table `user_department_relation_t` */

DROP TABLE IF EXISTS `user_department_relation_t`;

CREATE TABLE `user_department_relation_t` (
  `id` int(200) NOT NULL AUTO_INCREMENT COMMENT '关系ID',
  `department_id` int(200) DEFAULT NULL COMMENT '部门id',
  `department_code` int(200) DEFAULT NULL COMMENT '部门编号',
  `user_id` int(200) DEFAULT NULL COMMENT '用户ID',
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_department_relation_t` */

/*Table structure for table `user_role_relation_t` */

DROP TABLE IF EXISTS `user_role_relation_t`;

CREATE TABLE `user_role_relation_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(10) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(10) DEFAULT NULL COMMENT '角色ID',
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role_relation_t` */

/*Table structure for table `user_t` */

DROP TABLE IF EXISTS `user_t`;

CREATE TABLE `user_t` (
  `id` int(200) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户密码',
  `name` varchar(200) DEFAULT NULL COMMENT '用户名',
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user_t` */

insert  into `user_t`(`id`,`password`,`name`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (1,'1','1',0,'2019-10-31 20:26:42',NULL,NULL),(2,'1','2',0,'2019-10-31 20:27:34',NULL,NULL),(3,'1','3',0,'2019-10-31 20:33:37',NULL,NULL),(4,'1','4',0,'2019-10-31 20:35:52',NULL,NULL),(5,'54','54',0,'2019-10-31 21:05:32',NULL,NULL),(6,'123456','admin',NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
