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

 Date: 10/08/2021 16:48:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for s_menu
-- ----------------------------
DROP TABLE IF EXISTS `s_menu`;
CREATE TABLE `s_menu`  (
  `menu_Id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `menu_Url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `parent_Id` int(11) NULL DEFAULT NULL,
  `order_Num` int(11) NULL DEFAULT NULL,
  `menu_Type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `createBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `updateBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `createTime` date NULL DEFAULT NULL,
  PRIMARY KEY (`menu_Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_menu
-- ----------------------------
INSERT INTO `s_menu` VALUES (1, '系统管理', NULL, 0, 0, 'M', '0', '1', NULL, '2021-08-02');
INSERT INTO `s_menu` VALUES (2, '用户管理', NULL, 1, 0, 'C', '0', '1', NULL, '2021-08-02');
INSERT INTO `s_menu` VALUES (3, '角色管理', NULL, 1, 0, 'C', '0', '1', NULL, '2021-08-02');
INSERT INTO `s_menu` VALUES (4, '菜单管理', NULL, 1, 0, 'C', '0', '1', NULL, '2021-08-02');

SET FOREIGN_KEY_CHECKS = 1;
