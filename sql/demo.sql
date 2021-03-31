/*
Navicat MySQL Data Transfer

Source Server         : MySQLLocal
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-09-26 17:51:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(11) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '是否删除，0代表''未删除'',1代表已删除',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_on` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '修改人',
  `update_on` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'milo', '0', null, null, null, null);
INSERT INTO `users` VALUES ('2', 'xuexue', '0', null, null, null, null);
INSERT INTO `users` VALUES ('3', 'jone', '0', null, null, null, null);
