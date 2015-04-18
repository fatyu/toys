
CREATE DATABASE BLOG;

USE BLOG;

CREATE TABLE `blog` (
  `id` int(11) NOT NULL auto_increment,
  `category_id` int(11) default NULL,
  `title` varchar(400)  default NULL,
  `content` varchar(4000) default NULL,
  `createdtime` datetime default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_Relationship_1` (`category_id`)
);

CREATE TABLE `category` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(200) default NULL,
  `level` int(11) default NULL,
  PRIMARY KEY  (`id`)
);

CREATE TABLE `comment` (
  `id` int(11) NOT NULL auto_increment,
  `blog_id` int(11) default NULL,
  `username` varchar(200) NULL,
  `content` varchar(1000) NULL,
  `createdtime` datetime NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_Relationship_2` (`blog_id`)
) ;

CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(200) NULL,
  `password` varchar(200) NULL,
  PRIMARY KEY  (`id`)
);

