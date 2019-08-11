/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 12/08/2019 00:17:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `last_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `company` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `country` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `postal_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `fax` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `support_repld` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '1', '2', '北京', '北京', '北京', 1, '北京', '123456', '18316260997', '1', '853029827@qq.com', 1);

-- ----------------------------
-- Table structure for invoice
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice`  (
  `invoice_id` int(11) NOT NULL AUTO_INCREMENT,
  `invoice_date` date NULL DEFAULT NULL,
  `billing_address` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `billing_city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `billing_state` int(11) NULL DEFAULT NULL,
  `billing_country` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `billing_postalCode` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `total` decimal(10, 2) NULL DEFAULT NULL,
  `customer_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`invoice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of invoice
-- ----------------------------
INSERT INTO `invoice` VALUES (1, NULL, '1', 'b', NULL, '2', NULL, 5.00, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` int(1) NULL DEFAULT NULL,
  `register_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '89921218@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (2, '2@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-2', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (3, '3@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-3', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (4, '4@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-4', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (5, '5@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-5', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (6, '6@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-6', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (7, '7@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-7', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (8, '8@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-8', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (9, '9@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-9', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (10, '10@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-10', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (12, 'aquan', '123', 'aquan', 1, '2019-08-10 16:38:56');

SET FOREIGN_KEY_CHECKS = 1;
