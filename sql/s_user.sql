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

 Date: 10/08/2021 16:48:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_id` int(11) NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `createBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `updateBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `createTime` date NULL DEFAULT NULL,
  `updateTime` date NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES (1, 1, 'admin', NULL, NULL, NULL, NULL, NULL, '$2a$10$NxSSbfkrGYhsTMILpsn3A.5KYFX6gElKWAomYMdzHvFBAg/Zisl9y', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `s_user` VALUES (2, 5, 'people', NULL, NULL, NULL, NULL, NULL, '$2a$10$NxSSbfkrGYhsTMILpsn3A.5KYFX6gElKWAomYMdzHvFBAg/Zisl9y', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `s_user` VALUES (3, 3, 'qu', NULL, NULL, NULL, NULL, NULL, '$2a$10$NxSSbfkrGYhsTMILpsn3A.5KYFX6gElKWAomYMdzHvFBAg/Zisl9y', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `s_user` VALUES (4, 4, 'jd', NULL, NULL, NULL, NULL, NULL, '$2a$10$NxSSbfkrGYhsTMILpsn3A.5KYFX6gElKWAomYMdzHvFBAg/Zisl9y', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `s_user` VALUES (5, 2, 'xwqu', NULL, NULL, NULL, NULL, NULL, '$2a$10$NxSSbfkrGYhsTMILpsn3A.5KYFX6gElKWAomYMdzHvFBAg/Zisl9y', NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
