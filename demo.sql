-- ----------------------------
-- create database
-- ----------------------------
CREATE DATABASE `test` /*!40100 DEFAULT CHARACTER SET utf8 */;

-- ----------------------------
-- create table demo
-- ----------------------------
CREATE TABLE `test_demo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `info` varchar(45) NOT NULL COMMENT '信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='demo表';
-- ----------------------------
-- insert record into table demo
-- ----------------------------
INSERT INTO `test`.`test_demo` (`id`, `name`, `info`) VALUES ('1', 'demo', '从来扯着嗓门喊着要走的人，都是最后自己把摔了一地的玻璃碎片，闷头弯腰一片一片拾了起来。而真正想离开的人，只是挑了一个风和日丽的下午，裹了件最常穿的大衣，出了门，然后就再也没有回来过。\n\n');
-- ----------------------------
-- select table demo
-- ----------------------------
SELECT * FROM test.test_demo;
