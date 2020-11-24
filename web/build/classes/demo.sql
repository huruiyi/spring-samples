-- 会员管理系统		membermg_plus专用
-- 删除数据库，创建数据库
drop database if exists membermg_plus;
create database if not exists membermg_plus;
use membermg_plus;
 
 
 
-- 创建管理表
drop table if exists mguser;
create table if not exists mguser(
	id int(10) not null auto_increment,
	username varchar(50) not null,
	password varchar(50) not null,
	userphone varchar(20) not null,
	primary key(id)
);
 
-- 导入数据
insert into mguser values(default,'1234','1234','12345678912');
insert into mguser values(default,'111','111','12345678912');
select * from mguser;
 
 
-- 创建会员表
drop table if exists hyuser;
create table if not exists hyuser(
	id int not null auto_increment,
	username varchar(50) not null,
	userphone varchar(20) not null,
	money  bigint(100) not null,
	primary key(id)
);
 
-- 导入数据
insert into hyuser values(default,'a','12345678912',1250);
insert into hyuser values(default,'aa','12345678912',1100);
insert into hyuser values(default,'aaa','12345678912',1500);
insert into hyuser values(default,'aaaa','12345678912',1300);
insert into hyuser values(default,'b','12345678912',1200);
insert into hyuser values(default,'bb','12345678912',1600);
insert into hyuser values(default,'bbb','12345678912',1550);
select * from hyuser;