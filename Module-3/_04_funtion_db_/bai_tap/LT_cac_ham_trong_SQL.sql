drop database if exists bai_tap;

create database bai_tap;

use bai_tap;

create table hoc_sinh (
id int not null,
ho_ten varchar(50),
tuoi int,
khoa_hoc varchar(10),
so_tien int
);

insert into hoc_sinh
values
(1,'Hoang',21,'CNTT',400000),
(2,'Viet',19,'DTVT',320000),
(3,'Thanh',18,'KTDN',400000),
(4,'Nhan',19,'CK',450000),
(5,'Huong',20,'TCNH',500000),
(5,'Huong',20,'TCNH',200000);

SELECT 
    *
FROM
    hoc_sinh
WHERE
    id = 5;
    
SELECT 
    ho_ten, SUM(so_tien) 'tong_so_tien'
FROM
    hoc_sinh
WHERE
    ho_ten = 'Huong';
    
SELECT DISTINCT
    ho_ten
FROM
    hoc_sinh;