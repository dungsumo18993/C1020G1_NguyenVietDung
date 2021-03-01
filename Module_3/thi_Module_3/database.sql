drop database if exists quan_ly_sp;

create database quan_ly_sp;

use quan_ly_sp;


create table nhan_vien (
nhan_vien_id int not null auto_increment primary key,
ten_nhan_vien varchar(50),
ngay_sinh date,
dia_chi varchar(50)
);

create table khach_hang (
khach_hang_id int not null auto_increment primary key,
ten_khach_hang varchar(50),
ngay_sinh date,
phone varchar(45),
email varchar(45),
dia_chi varchar(45)
);

create table ql_don_hang (
don_hang_id int not null auto_increment primary key,
pt_thanh_toan varchar(50),
ngay_dat_hang date,
ngay_giao_hang date,
dia_chi_giao varchar(50),
khach_hang_id int,
nhan_vien_id int,

foreign key (khach_hang_id) references khach_hang (khach_hang_id)
on delete cascade,
foreign key (nhan_vien_id) references nhan_vien (nhan_vien_id)
on delete cascade
);

create table san_pham (
san_pham_id int not null auto_increment primary key,
ten_san_pham varchar(50),
gia_san_pham double,
muc_giam_gia int,
ton_kho int,
don_hang_id int,

foreign key (don_hang_id) references ql_don_hang (don_hang_id)
on delete cascade
);

insert into khach_hang
values
(1,"Trung","1990-09-11","0905123123","trung@gmail.com","Đà Nẵng"),
(2,"Hùng","1991-09-11","0905123124","hung@gmail.com","Quãng Nam"),
(3,"Dũng","1992-09-11","0905123125","dung@gmail.com","Hồ Chí Minh"),
(4,"Tùng","1993-09-11","0905123126","tung@gmail.com","Vinh"),
(5,"Dung","1994-09-11","0905123127","dung@gmail.com","Huế"),
(6,"Nhung","1995-09-11","0905123128","nhung@gmail.com","Quãng Ngãi"),
(7,"Hân","1996-09-11","0905123129","han@gmail.com","Đà Nẵng"),
(8,"Thanh","1997-09-11","0905123130","thanh@gmail.com","Quãng Nam"),
(9,"Quỳnh","1998-09-11","0905123131","quynh@gmail.com","Huế"),
(10,"Trúc","1999-09-11","0905123132","truc@gmail.com","Nghệ An");

insert into nhan_vien
values
(1,"Trang","2000-02-11","Đà Nẵng"),
(2,"Thịnh","2001-02-11","Quãng Nam"),
(3,"Kiên","2002-02-11","Vinh"),
(4,"Sơn","2003-02-11","Huế"),
(5,"Phúc","2004-02-11","Đà Nẵng"),
(6,"Anh","1999-02-11","Hồ Chí Minh"),
(7,"Phương","2001-02-11","Vinh"),
(8,"Cường","2002-02-11","Huế"),
(9,"Hoài","2003-02-11","Quãng Nam"),
(10,"Thu","2000-02-16","Đà Nẵng");

insert into ql_don_hang
values
(1,"cod","2021-01-01","2021-01-05","Huế",1,1),
(2,"thẻ","2021-01-06","2021-01-10","Vinh",2,2),
(3,"cod","2021-01-11","2021-01-15","Quãng Nam",3,3),
(4,"thẻ","2021-01-16","2021-01-20","Quãng Ngãi",4,4),
(5,"cod","2021-01-21","2021-01-25","Nghệ An",5,5),
(6,"thẻ","2021-01-26","2021-01-31","Hà Tĩnh",6,6),
(7,"cod","2021-02-01","2021-02-05","Huế",7,7),
(8,"thẻ","2021-03-01","2021-03-05","Quãng Ngãi",8,8),
(9,"cod","2021-04-01","2021-04-05","Vinh",9,9),
(10,"thẻ","2021-05-01","2021-05-05","Vũng Tàu",10,10);

insert into san_pham
values
(1,"Bàn",400,20,10,1),
(2,"Ghế",300,10,15,2),
(3,"Tủ",400,30,20,3),
(4,"Giường",500,15,10,4),
(5,"Tivi",600,5,15,5),
(6,"Lò vi sóng",800,10,10,6),
(7,"Bếp",600,15,20,7),
(8,"Bếp",400,20,15,8),
(9,"Loa",200,10,5,9),
(10,"Nồi Cơm",400,10,10,10);

select *
from san_pham
order by ten_san_pham desc, gia_san_pham;
