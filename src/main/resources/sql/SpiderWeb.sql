-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE SpiderWeb;
-- 使用数据库
USE SpiderWeb;

-- 创建世纪佳缘用户表
CREATE TABLE UserByJiaYuan(
    `user_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `realUid` BIGINT NOT NULL COMMENT '世纪佳缘Uid',
    `nickname` VARCHAR(100) NOT NULL COMMENT '昵称',
    `sex` VARCHAR(10) COMMENT '性别',
    `age` INT(3) COMMENT '年龄',
    `marriage` VARCHAR(10) COMMENT '婚否',
    `height` VARCHAR(10) COMMENT '身高',
    `education` VARCHAR(100) COMMENT '教育',
    `localhost` VARCHAR(100) COMMENT '居住地',
    `image` VARCHAR(500) COMMENT '头像Url',
    `randTag` VARCHAR(500) COMMENT '标签1',
    `randListTag` VARCHAR(500) COMMENT '标签2',
    `shortnote` VARCHAR(500) COMMENT '介绍',
    `matchCondition` VARCHAR(500) COMMENT '择偶条件',
    `helloUrl` VARCHAR(200) COMMENT '打招呼Url',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间',
    PRIMARY KEY (`user_id`),
	  KEY `userbyjiayuan_create_time` (`create_time`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='世纪佳缘用户表';