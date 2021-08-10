/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : activiti

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 10/08/2021 16:48:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for s_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `s_role_menu`;
CREATE TABLE `s_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_role_menu
-- ----------------------------
INSERT INTO `s_role_menu` VALUES (1, 1, 1);
INSERT INTO `s_role_menu` VALUES (10, 4, 1);
INSERT INTO `s_role_menu` VALUES (11, 4, 2);
INSERT INTO `s_role_menu` VALUES (12, 4, 3);
INSERT INTO `s_role_menu` VALUES (13, 4, 4);
INSERT INTO `s_role_menu` VALUES (14, 5, 1);
INSERT INTO `s_role_menu` VALUES (15, 5, 2);

SET FOREIGN_KEY_CHECKS = 1;
