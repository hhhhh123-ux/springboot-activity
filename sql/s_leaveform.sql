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

 Date: 10/08/2021 16:48:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for s_leaveform
-- ----------------------------
DROP TABLE IF EXISTS `s_leaveform`;
CREATE TABLE `s_leaveform`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `procInstId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '实例id',
  `proposer_Id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `agent_Id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `leaveType` int(11) NOT NULL,
  `leaveContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `leaveTime` timestamp NULL DEFAULT NULL COMMENT '生效时间',
  `expireTime` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '请假到期时间',
  `createTime` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `endTime` timestamp NULL DEFAULT NULL,
  `reply` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT 0,
  `currDate` date NULL DEFAULT NULL,
  `deptId` int(11) NULL DEFAULT NULL,
  `area` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_leaveform
-- ----------------------------
INSERT INTO `s_leaveform` VALUES (1, '15001', '1', NULL, '123', 0, '0', NULL, '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, 0, NULL, 5, 3);
INSERT INTO `s_leaveform` VALUES (2, '17501', '2', NULL, 'gggggg', 0, '0', NULL, '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, 0, NULL, 5, 3);
INSERT INTO `s_leaveform` VALUES (3, '20001', '2', NULL, 'gggggg', 0, '0', NULL, '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, 0, NULL, 4, 2);
INSERT INTO `s_leaveform` VALUES (4, '20007', '2', NULL, 'gghjk', 0, '0', NULL, '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, 0, NULL, 4, 2);
INSERT INTO `s_leaveform` VALUES (5, '20013', '2', NULL, 'gghjk', 0, '0', NULL, '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, 0, NULL, 4, 2);

SET FOREIGN_KEY_CHECKS = 1;
