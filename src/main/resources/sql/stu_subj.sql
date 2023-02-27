/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:4260
 Source Schema         : testcourse

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 24/02/2023 09:36:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for stu_subj
-- ----------------------------
DROP TABLE IF EXISTS `stu_subj`;
CREATE TABLE `stu_subj`  (
  `studentID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `subjectID` int NOT NULL,
  `choose` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`studentID`) USING BTREE,
  INDEX `subj`(`subjectID` ASC) USING BTREE,
  CONSTRAINT `stuid_student` FOREIGN KEY (`studentID`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `subid_subject` FOREIGN KEY (`subjectID`) REFERENCES `subject` (`subject_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of stu_subj
-- ----------------------------
INSERT INTO `stu_subj` VALUES ('0101', 1, '1');
INSERT INTO `stu_subj` VALUES ('0102', 2, '1');
INSERT INTO `stu_subj` VALUES ('0105', 3, '0');
INSERT INTO `stu_subj` VALUES ('01234', 2, '0');

SET FOREIGN_KEY_CHECKS = 1;
