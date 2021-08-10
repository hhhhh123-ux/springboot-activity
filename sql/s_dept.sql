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

 Date: 10/08/2021 16:48:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for s_dept
-- ----------------------------
DROP TABLE IF EXISTS `s_dept`;
CREATE TABLE `s_dept`  (
  `dept_Id` int(11) NOT NULL,
  `dept_Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `parent_Id` int(11) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `order_Num` int(11) NULL DEFAULT NULL,
  `createBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `updateBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `createTime` date NULL DEFAULT NULL,
  `shen` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`dept_Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_dept
-- ----------------------------
INSERT INTO `s_dept` VALUES (1, '南京市', 0, '0', 0, NULL, NULL, NULL, 'shi');
INSERT INTO `s_dept` VALUES (2, '玄武区', 1, '0', 0, NULL, NULL, NULL, 'area');
INSERT INTO `s_dept` VALUES (3, '栖霞区', 1, '0', 0, NULL, NULL, NULL, 'area');
INSERT INTO `s_dept` VALUES (4, '玄武街道', 2, '0', 0, NULL, NULL, NULL, 'jd');
INSERT INTO `s_dept` VALUES (5, '栖霞街道', 3, '0', 0, NULL, NULL, NULL, 'jd');

SET FOREIGN_KEY_CHECKS = 1;
