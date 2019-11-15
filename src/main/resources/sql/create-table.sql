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
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
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
  `is_exist_childen` char(1) DEFAULT NULL COMMENT '0存在1不存在',
  `parent_id` int(200) DEFAULT NULL COMMENT '父节点id',
  `department_level` int(200) DEFAULT NULL COMMENT '部门层级0/1/2/3',
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `department_t` */

insert  into `department_t`(`id`,`department_code`,`department_name`,`is_exist_childen`,`parent_id`,`department_level`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (25,NULL,'开发部',NULL,0,NULL,6,'2019-11-14 17:46:40',NULL,NULL);
insert  into `department_t`(`id`,`department_code`,`department_name`,`is_exist_childen`,`parent_id`,`department_level`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (26,NULL,'人事部',NULL,0,NULL,6,'2019-11-14 17:50:19',NULL,NULL);
insert  into `department_t`(`id`,`department_code`,`department_name`,`is_exist_childen`,`parent_id`,`department_level`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (27,NULL,'后勤部',NULL,0,NULL,6,'2019-11-14 17:50:31',NULL,NULL);
insert  into `department_t`(`id`,`department_code`,`department_name`,`is_exist_childen`,`parent_id`,`department_level`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (28,NULL,'安全部',NULL,0,NULL,6,'2019-11-14 17:50:47',NULL,NULL);
insert  into `department_t`(`id`,`department_code`,`department_name`,`is_exist_childen`,`parent_id`,`department_level`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (29,NULL,'采购部',NULL,0,NULL,6,'2019-11-14 17:50:53',NULL,NULL);
insert  into `department_t`(`id`,`department_code`,`department_name`,`is_exist_childen`,`parent_id`,`department_level`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (30,NULL,'需求部',NULL,0,NULL,6,'2019-11-14 17:50:57',NULL,NULL);
insert  into `department_t`(`id`,`department_code`,`department_name`,`is_exist_childen`,`parent_id`,`department_level`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (31,NULL,'物料部',NULL,0,NULL,6,'2019-11-14 17:51:03',NULL,NULL);
insert  into `department_t`(`id`,`department_code`,`department_name`,`is_exist_childen`,`parent_id`,`department_level`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (32,NULL,'企划部',NULL,0,NULL,6,'2019-11-14 17:51:18',NULL,NULL);
insert  into `department_t`(`id`,`department_code`,`department_name`,`is_exist_childen`,`parent_id`,`department_level`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (33,NULL,'外交部',NULL,0,NULL,6,'2019-11-14 17:51:22',NULL,NULL);
insert  into `department_t`(`id`,`department_code`,`department_name`,`is_exist_childen`,`parent_id`,`department_level`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (34,NULL,'总经办',NULL,0,NULL,6,'2019-11-14 17:51:36',NULL,NULL);
insert  into `department_t`(`id`,`department_code`,`department_name`,`is_exist_childen`,`parent_id`,`department_level`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (35,NULL,'营销部',NULL,0,NULL,6,'2019-11-14 17:51:42',NULL,NULL);

/*Table structure for table `department_user_relation_t` */

DROP TABLE IF EXISTS `department_user_relation_t`;

CREATE TABLE `department_user_relation_t` (
  `id` int(200) NOT NULL AUTO_INCREMENT COMMENT '关系ID',
  `department_id` int(200) DEFAULT NULL COMMENT '部门id',
  `department_code` int(200) DEFAULT NULL COMMENT '部门编号',
  `user_id` int(200) DEFAULT NULL COMMENT '用户ID',
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `department_user_relation_t` */

insert  into `department_user_relation_t`(`id`,`department_id`,`department_code`,`user_id`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (5,11,0,6,0,'2019-11-05 22:18:25',NULL,NULL);
insert  into `department_user_relation_t`(`id`,`department_id`,`department_code`,`user_id`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (6,11,0,6,0,'2019-11-08 17:26:09',NULL,NULL);
insert  into `department_user_relation_t`(`id`,`department_id`,`department_code`,`user_id`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (7,12,0,6,0,'2019-11-08 17:26:09',NULL,NULL);
insert  into `department_user_relation_t`(`id`,`department_id`,`department_code`,`user_id`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (8,15,0,6,0,'2019-11-08 17:26:09',NULL,NULL);
insert  into `department_user_relation_t`(`id`,`department_id`,`department_code`,`user_id`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (9,16,0,6,0,'2019-11-08 17:26:09',NULL,NULL);
insert  into `department_user_relation_t`(`id`,`department_id`,`department_code`,`user_id`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (10,14,0,6,0,'2019-11-08 17:26:09',NULL,NULL);

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
  `is_agree` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否通过0同意1驳回',
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程任务历史轨迹表';

/*Data for the table `hi_task_t` */

/*Table structure for table `materials_category_t` */

DROP TABLE IF EXISTS `materials_category_t`;

CREATE TABLE `materials_category_t` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(2000) DEFAULT NULL COMMENT '分类名称',
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='物料分类表';

/*Data for the table `materials_category_t` */

insert  into `materials_category_t`(`id`,`name`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (4,'办公',NULL,NULL,NULL,NULL);
insert  into `materials_category_t`(`id`,`name`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (5,'后勤',6,'2019-11-14 16:23:22',NULL,NULL);

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
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='物资需求表';

/*Data for the table `materials_need_t` */

insert  into `materials_need_t`(`id`,`title`,`materials_sort`,`materials_code`,`need_count`,`need_date`,`need_unit`,`technical_parameters`,`remark`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (2,'string','string','string',1,NULL,'string','string','string',0,'2019-11-12 15:48:33',NULL,NULL);

/*Table structure for table `materials_plan_t` */

DROP TABLE IF EXISTS `materials_plan_t`;

CREATE TABLE `materials_plan_t` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `plan_status` varchar(200) DEFAULT NULL COMMENT '需求计划状态0自由1已删除2已提交汇总3已计划',
  `is_within_need` varchar(20) DEFAULT NULL COMMENT '是否计划内需求',
  `plan_user_id` int(20) DEFAULT NULL COMMENT '需求人员id',
  `plan_department_id` int(20) DEFAULT NULL COMMENT '需求部门id',
  `plan_type` varchar(2000) DEFAULT NULL COMMENT '需求计划类型',
  `plan_specification` varchar(2000) DEFAULT NULL COMMENT '规格',
  `plan_version` varchar(2000) DEFAULT NULL COMMENT '型号',
  `plan_unit` varchar(2000) DEFAULT NULL COMMENT '单位',
  `plan_count` int(20) DEFAULT NULL COMMENT '计划数量',
  `plan_month` varchar(2000) DEFAULT NULL COMMENT '计划月份，格式为“年度+月度',
  `plan_date` datetime DEFAULT NULL COMMENT '计划日期',
  `is_supply_confirm` varchar(200) DEFAULT NULL COMMENT '是否确定货源',
  `plan_code` varchar(200) DEFAULT NULL COMMENT '需求计划编码',
  `expecte_supplier` varchar(2000) DEFAULT NULL COMMENT '期待供应商',
  `fixate_supplier` varchar(2000) DEFAULT NULL COMMENT '固定供应商',
  `inventory_organization` varchar(2000) DEFAULT NULL COMMENT '库存组织',
  `material_trace_code` varchar(2000) DEFAULT NULL COMMENT '物料追踪码',
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='物料计划表';

/*Data for the table `materials_plan_t` */

insert  into `materials_plan_t`(`id`,`plan_status`,`is_within_need`,`plan_user_id`,`plan_department_id`,`plan_type`,`plan_specification`,`plan_version`,`plan_unit`,`plan_count`,`plan_month`,`plan_date`,`is_supply_confirm`,`plan_code`,`expecte_supplier`,`fixate_supplier`,`inventory_organization`,`material_trace_code`,`remark`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (1,'1','1',1,1,'1','1','1','1',1,'1','2019-11-12 20:09:16','1','1','1','1','1','1','1',NULL,NULL,NULL,NULL);
insert  into `materials_plan_t`(`id`,`plan_status`,`is_within_need`,`plan_user_id`,`plan_department_id`,`plan_type`,`plan_specification`,`plan_version`,`plan_unit`,`plan_count`,`plan_month`,`plan_date`,`is_supply_confirm`,`plan_code`,`expecte_supplier`,`fixate_supplier`,`inventory_organization`,`material_trace_code`,`remark`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (2,'2','2',2,2,'2','2','2','2',2,'2','2019-11-12 20:09:40','2','2','2','2','2','2','2',NULL,NULL,NULL,NULL);
insert  into `materials_plan_t`(`id`,`plan_status`,`is_within_need`,`plan_user_id`,`plan_department_id`,`plan_type`,`plan_specification`,`plan_version`,`plan_unit`,`plan_count`,`plan_month`,`plan_date`,`is_supply_confirm`,`plan_code`,`expecte_supplier`,`fixate_supplier`,`inventory_organization`,`material_trace_code`,`remark`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (3,'string','string',0,0,'string','string','string','string',0,'string',NULL,'string','string','0','0','string','string','string',NULL,NULL,NULL,NULL);
insert  into `materials_plan_t`(`id`,`plan_status`,`is_within_need`,`plan_user_id`,`plan_department_id`,`plan_type`,`plan_specification`,`plan_version`,`plan_unit`,`plan_count`,`plan_month`,`plan_date`,`is_supply_confirm`,`plan_code`,`expecte_supplier`,`fixate_supplier`,`inventory_organization`,`material_trace_code`,`remark`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (4,'string','string',0,0,'string','string','string','string',0,'string',NULL,'string','string','0','0','string','string','string',7,'2019-11-13 21:35:37',NULL,NULL);
insert  into `materials_plan_t`(`id`,`plan_status`,`is_within_need`,`plan_user_id`,`plan_department_id`,`plan_type`,`plan_specification`,`plan_version`,`plan_unit`,`plan_count`,`plan_month`,`plan_date`,`is_supply_confirm`,`plan_code`,`expecte_supplier`,`fixate_supplier`,`inventory_organization`,`material_trace_code`,`remark`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (5,'string','string',0,0,'string','string','string','string',0,'string',NULL,'string','string','0','0','string','string','string',7,'2019-11-15 16:28:48',NULL,NULL);
insert  into `materials_plan_t`(`id`,`plan_status`,`is_within_need`,`plan_user_id`,`plan_department_id`,`plan_type`,`plan_specification`,`plan_version`,`plan_unit`,`plan_count`,`plan_month`,`plan_date`,`is_supply_confirm`,`plan_code`,`expecte_supplier`,`fixate_supplier`,`inventory_organization`,`material_trace_code`,`remark`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (6,'string','string',0,0,'string','string','string','string',0,'string',NULL,'string','string','0','0','string','string','string',6,'2019-11-15 16:30:36',NULL,NULL);
insert  into `materials_plan_t`(`id`,`plan_status`,`is_within_need`,`plan_user_id`,`plan_department_id`,`plan_type`,`plan_specification`,`plan_version`,`plan_unit`,`plan_count`,`plan_month`,`plan_date`,`is_supply_confirm`,`plan_code`,`expecte_supplier`,`fixate_supplier`,`inventory_organization`,`material_trace_code`,`remark`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (7,'string','string',0,0,'string','string','string','string',0,'string',NULL,'string','string','0','0','string','string','string',7,'2019-11-15 16:40:13',NULL,NULL);
insert  into `materials_plan_t`(`id`,`plan_status`,`is_within_need`,`plan_user_id`,`plan_department_id`,`plan_type`,`plan_specification`,`plan_version`,`plan_unit`,`plan_count`,`plan_month`,`plan_date`,`is_supply_confirm`,`plan_code`,`expecte_supplier`,`fixate_supplier`,`inventory_organization`,`material_trace_code`,`remark`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (8,'Free','true',0,25,'PP_YEAR','1','1','5',121,'201911',NULL,'true',NULL,'4','5','121',NULL,NULL,7,'2019-11-15 16:53:46',NULL,NULL);
insert  into `materials_plan_t`(`id`,`plan_status`,`is_within_need`,`plan_user_id`,`plan_department_id`,`plan_type`,`plan_specification`,`plan_version`,`plan_unit`,`plan_count`,`plan_month`,`plan_date`,`is_supply_confirm`,`plan_code`,`expecte_supplier`,`fixate_supplier`,`inventory_organization`,`material_trace_code`,`remark`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (9,'Free','true',0,25,'PP_YEAR','1','1','5',121,'201911','2019-11-15 16:48:27','true',NULL,'4','5','121',NULL,NULL,7,'2019-11-15 16:54:52',NULL,NULL);
insert  into `materials_plan_t`(`id`,`plan_status`,`is_within_need`,`plan_user_id`,`plan_department_id`,`plan_type`,`plan_specification`,`plan_version`,`plan_unit`,`plan_count`,`plan_month`,`plan_date`,`is_supply_confirm`,`plan_code`,`expecte_supplier`,`fixate_supplier`,`inventory_organization`,`material_trace_code`,`remark`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (10,'Free','true',0,25,'PP_YEAR','1','1','5',121,'201911','2019-11-15 16:48:27','true',NULL,'4','5','121',NULL,NULL,7,'2019-11-15 16:55:48',NULL,NULL);
insert  into `materials_plan_t`(`id`,`plan_status`,`is_within_need`,`plan_user_id`,`plan_department_id`,`plan_type`,`plan_specification`,`plan_version`,`plan_unit`,`plan_count`,`plan_month`,`plan_date`,`is_supply_confirm`,`plan_code`,`expecte_supplier`,`fixate_supplier`,`inventory_organization`,`material_trace_code`,`remark`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (11,'Free','true',0,25,'PP_YEAR','1','1','5',121,'201911','2019-11-15 08:48:27','true',NULL,'4','5','121',NULL,NULL,7,'2019-11-15 17:20:25',NULL,NULL);

/*Table structure for table `materials_t` */

DROP TABLE IF EXISTS `materials_t`;

CREATE TABLE `materials_t` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(2000) DEFAULT NULL COMMENT '名称',
  `code` varchar(200) DEFAULT NULL COMMENT '编码',
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `materials_t` */

insert  into `materials_t`(`id`,`name`,`code`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (6,'打印纸','4',6,'2019-11-14 16:21:06',NULL,NULL);
insert  into `materials_t`(`id`,`name`,`code`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (7,'打印专用墨水','4',6,'2019-11-14 16:21:33',NULL,NULL);
insert  into `materials_t`(`id`,`name`,`code`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (8,'扫把','5',6,'2019-11-14 16:23:32',NULL,NULL);
insert  into `materials_t`(`id`,`name`,`code`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (9,'拖把','5',6,'2019-11-14 16:23:38',NULL,NULL);

/*Table structure for table `role_t` */

DROP TABLE IF EXISTS `role_t`;

CREATE TABLE `role_t` (
  `id` int(200) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名',
  `role_code` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色编码',
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `role_t` */

insert  into `role_t`(`id`,`role_name`,`role_code`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (21,'超级管理员','0',0,'2019-11-06 11:10:45',NULL,NULL);
insert  into `role_t`(`id`,`role_name`,`role_code`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (22,'管理员','0',0,'2019-11-06 11:10:51',NULL,NULL);
insert  into `role_t`(`id`,`role_name`,`role_code`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (25,'hhaa','0',7,'2019-11-13 21:36:43',NULL,NULL);
insert  into `role_t`(`id`,`role_name`,`role_code`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (26,'SHDIE','0',7,'2019-11-13 21:50:09',NULL,NULL);

/*Table structure for table `ru_task_t` */

DROP TABLE IF EXISTS `ru_task_t`;

CREATE TABLE `ru_task_t` (
  `id` int(200) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `business_key` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务主键',
  `proc_inst_id` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '实例id',
  `task_to` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务处理人',
  `assignee` char(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务提交人',
  `task_name` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务名称',
  `is_agree` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否通过0同意1驳回',
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ru_task_t` */

/*Table structure for table `supplier_t` */

DROP TABLE IF EXISTS `supplier_t`;

CREATE TABLE `supplier_t` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '供应商id',
  `name` varchar(2000) DEFAULT NULL COMMENT '供应商名称',
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='供应商表';

/*Data for the table `supplier_t` */

insert  into `supplier_t`(`id`,`name`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (4,'北京物料供应商',6,'2019-11-14 16:53:59',NULL,NULL);
insert  into `supplier_t`(`id`,`name`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (5,'天津物料供应商',6,'2019-11-14 16:55:55',NULL,NULL);

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
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `task_todo_t` */

/*Table structure for table `unit_t` */

DROP TABLE IF EXISTS `unit_t`;

CREATE TABLE `unit_t` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '物料单位id',
  `name` varchar(2000) DEFAULT NULL COMMENT '物料单位名称',
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='物料单位表';

/*Data for the table `unit_t` */

insert  into `unit_t`(`id`,`name`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (5,'棵',NULL,NULL,NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `user_role_relation_t` */

insert  into `user_role_relation_t`(`id`,`user_id`,`role_id`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (1,0,0,0,'2019-11-07 16:26:39',NULL,NULL);
insert  into `user_role_relation_t`(`id`,`user_id`,`role_id`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (2,6,21,0,'2019-11-08 17:08:46',NULL,NULL);
insert  into `user_role_relation_t`(`id`,`user_id`,`role_id`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (3,6,22,0,'2019-11-08 17:08:46',NULL,NULL);
insert  into `user_role_relation_t`(`id`,`user_id`,`role_id`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (4,6,21,0,'2019-11-08 17:10:44',NULL,NULL);
insert  into `user_role_relation_t`(`id`,`user_id`,`role_id`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (5,6,22,0,'2019-11-08 17:10:44',NULL,NULL);

/*Table structure for table `user_t` */

DROP TABLE IF EXISTS `user_t`;

CREATE TABLE `user_t` (
  `id` int(200) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(200) DEFAULT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户密码',
  `creater_by` int(200) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` int(200) DEFAULT NULL COMMENT '最后更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `user_t` */

insert  into `user_t`(`id`,`name`,`password`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (6,'admin','123456',NULL,NULL,NULL,NULL);
insert  into `user_t`(`id`,`name`,`password`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (7,'string','string',0,'2019-11-04 09:57:15',NULL,NULL);
insert  into `user_t`(`id`,`name`,`password`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (8,'admin1','123456',0,'2019-11-04 17:48:01',NULL,NULL);
insert  into `user_t`(`id`,`name`,`password`,`creater_by`,`create_date`,`last_update_by`,`last_update_date`) values (9,'admin2','111111',0,'2019-11-04 18:00:27',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
