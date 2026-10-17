/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2026-05-19 14:16:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `dir_path` varchar(255) DEFAULT NULL COMMENT '部门的上级分类层级id',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级部门',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '部门1', '/1', null);
INSERT INTO `t_department` VALUES ('2', '部门2', '/2', null);
INSERT INTO `t_department` VALUES ('3', '部门3', '/3', null);
INSERT INTO `t_department` VALUES ('4', '部门4', '/4', null);
INSERT INTO `t_department` VALUES ('5', '部门5', '/2/5', '2');
INSERT INTO `t_department` VALUES ('6', '部门6', '/2/5/6', '5');
INSERT INTO `t_department` VALUES ('7', '部门7', '/2/7', '2');
INSERT INTO `t_department` VALUES ('8', '部门8', '/3/8', '3');
INSERT INTO `t_department` VALUES ('9', '部门9', '/3/9', '3');
INSERT INTO `t_department` VALUES ('10', '部门10', '/2/5/10', '5');
INSERT INTO `t_department` VALUES ('11', '部门11', '/3/9/11', '9');
INSERT INTO `t_department` VALUES ('12', '部门12', '/3/9/12', '9');
INSERT INTO `t_department` VALUES ('13', '部门13', '/1/13', '1');
INSERT INTO `t_department` VALUES ('14', '部门14', '/1/14', '1');
INSERT INTO `t_department` VALUES ('15', '部门15', '/4/15', '4');
INSERT INTO `t_department` VALUES ('16', '部门16', '/4/16', '4');
INSERT INTO `t_department` VALUES ('17', '部门17', '/2/7/17', '7');
INSERT INTO `t_department` VALUES ('18', '部门18', '/2/7/18', '7');
INSERT INTO `t_department` VALUES ('19', '部门19', '/3/8/19', '8');
INSERT INTO `t_department` VALUES ('20', '部门20', '/3/8/20', '8');
INSERT INTO `t_department` VALUES ('21', '部门21', '/3/8/20/21', '20');
INSERT INTO `t_department` VALUES ('22', '部门22', '/3/8/20/22', '20');
INSERT INTO `t_department` VALUES ('23', '部门23', '/2/7/18/23', '18');
