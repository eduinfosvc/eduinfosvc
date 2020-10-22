/*
MySQL Data Transfer
Source Host: localhost
Source Database: eduinfosvc
Target Host: localhost
Target Database: eduinfosvc
Date: 2020/10/21 15:26:02
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for educolumn
-- ----------------------------
CREATE TABLE `educolumn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `column_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for organize
-- ----------------------------
CREATE TABLE `organize` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `organize_name` varchar(50) NOT NULL,
  `organize_note` varchar(50) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `organize_organize` (`parent_id`),
  CONSTRAINT `organize_organize` FOREIGN KEY (`parent_id`) REFERENCES `organize` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) NOT NULL,
  `user_sex` varchar(2) NOT NULL,
  `user_phone` bigint(20) NOT NULL,
  `user_pass` varchar(25) NOT NULL,
  `user_role` int(11) NOT NULL,
  `user_status` int(11) NOT NULL,
  `user_note` varchar(100) DEFAULT NULL,
  `organize_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_phone` (`user_phone`),
  KEY `user_organize` (`organize_id`),
  CONSTRAINT `user_organize` FOREIGN KEY (`organize_id`) REFERENCES `organize` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for user_permission
-- ----------------------------
CREATE TABLE `user_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `column_id` int(11) NOT NULL,
  `upload_power` bit(1) DEFAULT NULL,
  `check_power` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `up_user` (`user_id`),
  KEY `up_column` (`column_id`),
  CONSTRAINT `up_column` FOREIGN KEY (`column_id`) REFERENCES `educolumn` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `up_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `educolumn` VALUES ('1', 'A栏目');
INSERT INTO `educolumn` VALUES ('2', 'B栏目');
INSERT INTO `educolumn` VALUES ('3', 'C栏目');
INSERT INTO `educolumn` VALUES ('4', 'D栏目');
INSERT INTO `educolumn` VALUES ('5', 'E栏目');
INSERT INTO `organize` VALUES ('1', '小学', '这是小学', null);
INSERT INTO `organize` VALUES ('2', '中学', '这是一所中学', null);
INSERT INTO `organize` VALUES ('3', '大学', '这是一所大学', null);
INSERT INTO `organize` VALUES ('4', '教务处-小', '小学的教务处', '1');
INSERT INTO `organize` VALUES ('5', '招生处-小', '小学的招生处', '1');
INSERT INTO `organize` VALUES ('6', '招生办公室1-小', '小学的招生办公室1', '5');
INSERT INTO `organize` VALUES ('7', '招生办公室2-小', '小学的招生办公室2', '5');
INSERT INTO `organize` VALUES ('8', '教务处-中', '中学的教务处', '2');
INSERT INTO `organize` VALUES ('9', '招生处-中', '中学的招生处', '2');
INSERT INTO `organize` VALUES ('10', '招生办公室1-中', '中学的招生办公室1', '9');
INSERT INTO `organize` VALUES ('11', '招生办公室2-中', '中学的招生办公室2', '9');
INSERT INTO `organize` VALUES ('12', '教务处-大', '大学的教务处', '3');
INSERT INTO `organize` VALUES ('13', '招生处-大', '大学的招生处', '3');
INSERT INTO `organize` VALUES ('14', '招生办公室1-大', '大学的招生办公室1', '13');
INSERT INTO `organize` VALUES ('15', '招生办公室2-大', '大学的招生办公室2', '13');
INSERT INTO `organize` VALUES ('18', '太原理工大学', '太原理工', null);
INSERT INTO `organize` VALUES ('19', '教务处', '教务', null);
INSERT INTO `organize` VALUES ('20', '教务处', '教务', '18');
INSERT INTO `user` VALUES ('1', '系统管理员', '无', '18834131990', 'xitongguanliyuan', '0', '1', null, null);
INSERT INTO `user` VALUES ('2', '小学管理员-小明', '男', '18834131956', 'xiaoming', '1', '0', '小明犯了错误', '1');
INSERT INTO `user` VALUES ('3', '小学管理员-小珍', '女', '18834131991', 'xiaozhen', '1', '0', '小珍被开除了', '1');
INSERT INTO `user` VALUES ('4', '小学招生处处长-小王', '男', '18834131992', 'xiaowang', '2', '1', null, '5');
INSERT INTO `user` VALUES ('5', '小学招生处办1-小张', '男', '18834131993', 'xiaozhang', '2', '1', null, '6');
INSERT INTO `user` VALUES ('6', '小学招生处办1-小玲', '女', '18834131994', 'xiaoling', '2', '0', '小玲犯了错误', '6');
INSERT INTO `user` VALUES ('9', 'tanwenchao', '男', '18834131980', '12345678', '1', '1', null, '8');
INSERT INTO `user` VALUES ('10', '谭文超', '男', '18834131908', 'tanwenchao', '2', '1', null, '4');
INSERT INTO `user_permission` VALUES ('1', '4', '1', '', '');
INSERT INTO `user_permission` VALUES ('2', '4', '2', '', '');
INSERT INTO `user_permission` VALUES ('3', '4', '3', '', '');
INSERT INTO `user_permission` VALUES ('4', '4', '4', '', '');
INSERT INTO `user_permission` VALUES ('5', '4', '5', '', '');
INSERT INTO `user_permission` VALUES ('6', '5', '1', '', '');
INSERT INTO `user_permission` VALUES ('7', '5', '2', '', '');
INSERT INTO `user_permission` VALUES ('8', '5', '3', '', '');
INSERT INTO `user_permission` VALUES ('9', '5', '4', '', '');
INSERT INTO `user_permission` VALUES ('10', '5', '5', '', '');
INSERT INTO `user_permission` VALUES ('11', '10', '1', '', '');
INSERT INTO `user_permission` VALUES ('12', '10', '2', '', '');
INSERT INTO `user_permission` VALUES ('13', '10', '3', '', '');
INSERT INTO `user_permission` VALUES ('14', '10', '4', '', '');
INSERT INTO `user_permission` VALUES ('15', '10', '5', '', '');
INSERT INTO `user_permission` VALUES ('16', '6', '1', '', '');
INSERT INTO `user_permission` VALUES ('17', '6', '2', '', '');
INSERT INTO `user_permission` VALUES ('18', '6', '3', '', '');
INSERT INTO `user_permission` VALUES ('19', '6', '4', '', '');
INSERT INTO `user_permission` VALUES ('20', '6', '5', '', '');
