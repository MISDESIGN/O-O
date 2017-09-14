/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : express

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2017-09-14 20:36:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `express`
-- ----------------------------
DROP TABLE IF EXISTS `express`;
CREATE TABLE `express` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `sender` varchar(20) DEFAULT NULL,
  `sender_phone` varchar(20) DEFAULT NULL,
  `sender_addr` varchar(50) DEFAULT NULL,
  `receiver` varchar(20) DEFAULT NULL,
  `receiver_phone` varchar(20) DEFAULT NULL,
  `receiver_addr` varchar(50) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of express
-- ----------------------------
INSERT INTO `express` VALUES ('1', '100', 'mick', '17611111111', '湖南省长沙市', 'mickkong', '13411111111', '湖南省永州市', '已签收');
