/*
Navicat MySQL Data Transfer

Source Server         : myStudent
Source Server Version : 50733
Source Host           : localhost:3306
Source Database       : book_manage

Target Server Type    : MYSQL
Target Server Version : 50733
File Encoding         : 65001

Date: 2024-03-01 15:52:38
*/

SET
FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`
(
    `id`    int(11) NOT NULL AUTO_INCREMENT,
    `title` varchar(255) NOT NULL,
    `desc`  varchar(255)   DEFAULT NULL,
    `price` decimal(10, 0) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book`
VALUES ('1', '斗破苍穹', '消炎拌猪吃老虎的装13故事', '18');
INSERT INTO `book`
VALUES ('2', '博人传', '咬打火机都比博燃', '36');
INSERT INTO `book`
VALUES ('3', '偶像练习生', '坤坤练习两年半的故事', '25');

-- ----------------------------
-- Table structure for `borrow`
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`
(
    `id`   int(11) NOT NULL AUTO_INCREMENT,
    `sid`  int(11) DEFAULT NULL,
    `bid`  int(11) DEFAULT NULL,
    `time` datetime DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY    `borrow_book_id_fk` (`bid`),
    KEY    `borrow_student_id_fk` (`sid`),
    CONSTRAINT `borrow_book_id_fk` FOREIGN KEY (`bid`) REFERENCES `book` (`id`),
    CONSTRAINT `borrow_student_id_fk` FOREIGN KEY (`sid`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow`
VALUES ('2', '1', '1', '2024-02-29 16:56:05');

-- ----------------------------
-- Table structure for `persistent_logins`
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`
(
    `username`  varchar(64) NOT NULL,
    `series`    varchar(64) NOT NULL,
    `token`     varchar(64) NOT NULL,
    `last_used` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `persistent_logins`
VALUES ('admin', '+OIfPc7pu6BSYr7VmUY+LQ==', 'AmTyCsmmk3UnpPgHDVYFGA==', '2024-03-01 14:51:49');
INSERT INTO `persistent_logins`
VALUES ('admin', '4qlVsY/OXbMZhxpjlA1Ehw==', 'U+GFm6lpy/6BSkMoKufvXQ==', '2024-02-29 16:55:57');
INSERT INTO `persistent_logins`
VALUES ('admin', 'mN8G1ut0d2mKGQMADtpnsw==', '0IjI7nTnDvdb7s9rgYrcCg==', '2024-03-01 15:09:37');
INSERT INTO `persistent_logins`
VALUES ('admin', 'SR4bR9fOMuxKRhmCf+xK8Q==', 'YlHe4V5AkxeikfP65YkPyA==', '2024-03-01 15:24:23');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `id`    int(11) NOT NULL AUTO_INCREMENT,
    `name`  varchar(255) NOT NULL,
    `sex`   varchar(255) DEFAULT NULL,
    `grade` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student`
VALUES ('1', '小明', '男', '1');
INSERT INTO `student`
VALUES ('2', '小红', '女', '2');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(255) NOT NULL,
    `password` varchar(255) DEFAULT '123456',
    `role`     varchar(20)  DEFAULT 'User',
    PRIMARY KEY (`id`),
    UNIQUE KEY `user_username_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES ('1', 'user', '123456', 'user');
INSERT INTO `user`
VALUES ('2', 'admin', '123456', 'admin');
