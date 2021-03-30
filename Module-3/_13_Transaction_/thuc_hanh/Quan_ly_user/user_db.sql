drop database if exists demo;

CREATE DATABASE demo;
USE demo;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 city varchar(120),
 PRIMARY KEY (id)
);

insert into users (`name`,email, city)
values ('Minh','minh@codegym.vn','Viet Nam'),
		('Dương','duong@gmail.vn','Hải Phòng'),
        ('Huy','huy@gmai.com','Đà Nẵng'),
        ('Hà','ha@gmail.com','Hà Nội');