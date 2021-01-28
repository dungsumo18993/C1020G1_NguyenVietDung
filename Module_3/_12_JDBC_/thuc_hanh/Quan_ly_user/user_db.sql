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

create table Permision(

id int(11) auto_increment primary key,

name varchar(50)

);

create table User_Permision(

permision_id int(11),

user_id int(11)

);

insert into users (`name`,email, city)
values ('Minh','minh@codegym.vn','Viet Nam'),
		('Dương','duong@gmail.vn','Hải Phòng'),
        ('Huy','huy@gmai.com','Đà Nẵng'),
        ('Hà','ha@gmail.com','Hà Nội');
        
insert into Permision(name)
 values ('add'),
		('edit'),
        ('delete'),
        ('view');
        
DELIMITER //

CREATE PROCEDURE get_user_by_id(IN user_id INT)

BEGIN

    SELECT users.name, users.email, users.city

    FROM users

    where users.id = user_id;

    END;

// DELIMITER ;

DELIMITER //

CREATE PROCEDURE insert_user(

IN user_name varchar(50),

IN user_email varchar(50),

IN user_city varchar(50)

)

BEGIN

    INSERT INTO users(name, email, city) VALUES(user_name, user_email, user_city);

    END;

// DELIMITER ;