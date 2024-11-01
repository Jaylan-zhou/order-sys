/*
 Navicat Premium Dump SQL

 Source Server         : order-sys-zhoujunyu
 Source Server Type    : MySQL
 Source Server Version : 80300 (8.3.0)
 Source Host           : localhost:3306
 Source Schema         : order

 Target Server Type    : MySQL
 Target Server Version : 80300 (8.3.0)
 File Encoding         : 65001

 Date: 21/10/2024 11:27:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for caipin
-- ----------------------------
DROP TABLE IF EXISTS `caipin`;
CREATE TABLE `caipin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `caipin_name` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `yuanjia` float DEFAULT NULL,
  `kouwei` varchar(255) DEFAULT NULL,
  `yuexiao` int DEFAULT NULL,
  `shangxiajia` int DEFAULT NULL,
  `blong_clazz` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of caipin
-- ----------------------------
BEGIN;
INSERT INTO `caipin` (`id`, `caipin_name`, `photo`, `price`, `yuanjia`, `kouwei`, `yuexiao`, `shangxiajia`, `blong_clazz`) VALUES (1, '西瓜', 'ajdbaibdfa', 15, 10, '好吃', 100, 1, '水果类');
INSERT INTO `caipin` (`id`, `caipin_name`, `photo`, `price`, `yuanjia`, `kouwei`, `yuexiao`, `shangxiajia`, `blong_clazz`) VALUES (2, '水煮青菜', 'ajfabgahfg', 5, 2, '一般', 150, 0, '蔬菜类');
COMMIT;

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz` (
  `id` int NOT NULL AUTO_INCREMENT,
  `clazzname` varchar(255) DEFAULT NULL,
  `weight` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of clazz
-- ----------------------------
BEGIN;
INSERT INTO `clazz` (`id`, `clazzname`, `weight`) VALUES (1, '蔬菜', 12);
INSERT INTO `clazz` (`id`, `clazzname`, `weight`) VALUES (2, '水果', 34);
COMMIT;

-- ----------------------------
-- Table structure for dingdan
-- ----------------------------
DROP TABLE IF EXISTS `dingdan`;
CREATE TABLE `dingdan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `table_id` int DEFAULT NULL,
  `person_number` int DEFAULT NULL,
  `beizhu` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `complete_time` datetime DEFAULT NULL,
  `concel_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of dingdan
-- ----------------------------
BEGIN;
INSERT INTO `dingdan` (`id`, `table_id`, `person_number`, `beizhu`, `price`, `status`, `order_time`, `pay_time`, `complete_time`, `concel_time`) VALUES (1, 1, 5, '张三', 9, 0, '2024-10-17 10:47:39', '2024-10-17 10:47:54', '2024-10-17 10:47:57', '2024-10-17 10:48:00');
INSERT INTO `dingdan` (`id`, `table_id`, `person_number`, `beizhu`, `price`, `status`, `order_time`, `pay_time`, `complete_time`, `concel_time`) VALUES (2, 2, 3, '李四', 123, 1, '2024-10-17 10:48:27', '2024-10-17 10:48:29', '2024-10-17 10:48:38', '2024-10-17 10:48:44');
COMMIT;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `orders_id` int DEFAULT NULL,
  `orders_name` varchar(255) DEFAULT NULL,
  `caipin_price` float DEFAULT NULL,
  `caipin_photo` varchar(255) DEFAULT NULL,
  `number` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
BEGIN;
INSERT INTO `order_detail` (`id`, `orders_id`, `orders_name`, `caipin_price`, `caipin_photo`, `number`) VALUES (1, 1, 'order1', 5, 'fjkgnalg', 2);
INSERT INTO `order_detail` (`id`, `orders_id`, `orders_name`, `caipin_price`, `caipin_photo`, `number`) VALUES (2, 2, 'order2', 8, 'fagnjaghjg', 9);
COMMIT;

-- ----------------------------
-- Table structure for shopping_car
-- ----------------------------
DROP TABLE IF EXISTS `shopping_car`;
CREATE TABLE `shopping_car` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tables_id` int DEFAULT NULL,
  `caipin_id` int DEFAULT NULL,
  `number` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of shopping_car
-- ----------------------------
BEGIN;
INSERT INTO `shopping_car` (`id`, `tables_id`, `caipin_id`, `number`) VALUES (1, 1, 1, 4);
INSERT INTO `shopping_car` (`id`, `tables_id`, `caipin_id`, `number`) VALUES (2, 2, 2, 5);
COMMIT;

-- ----------------------------
-- Table structure for table_info
-- ----------------------------
DROP TABLE IF EXISTS `table_info`;
CREATE TABLE `table_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `table_name` varchar(255) DEFAULT NULL,
  `QRcode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of table_info
-- ----------------------------
BEGIN;
INSERT INTO `table_info` (`id`, `table_name`, `QRcode`) VALUES (2, 'desk2', 'ahjgkashf');
INSERT INTO `table_info` (`id`, `table_name`, `QRcode`) VALUES (3, 'desk3', 'ajignaohgoahgf');
INSERT INTO `table_info` (`id`, `table_name`, `QRcode`) VALUES (7, 'desk7', 'agagha');
INSERT INTO `table_info` (`id`, `table_name`, `QRcode`) VALUES (8, 'desk8', 'adhashdoahdfo');
INSERT INTO `table_info` (`id`, `table_name`, `QRcode`) VALUES (9, 'desk999', 'agaoshiosahdfioa');
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` (`id`, `account`, `code`) VALUES (1, '张三', '123');
INSERT INTO `users` (`id`, `account`, `code`) VALUES (2, '李四', '12345');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
