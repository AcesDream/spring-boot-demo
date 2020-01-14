/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : spring-boot-demo

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2020-01-14 18:51:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `user_age` int(11) DEFAULT NULL COMMENT '年龄',
  `user_birthday` date DEFAULT NULL,
  `user_sex` bit(1) DEFAULT NULL COMMENT '性别（0：女；1：男）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
