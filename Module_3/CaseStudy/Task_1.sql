use furama;

insert into vitri 
values (1,'Lễ Tân'),
	   (2,'Nhân Viên'),
       (3,'Tiếp Tân'),
       (4,'Quản Lý'),
       (5,'Dọn vệ sinh');
       
insert into trinhdo 
values (1,'Đại Học'),
	   (2,'Cao Đẳng'),
       (3,'Trung Cấp');
       
insert into bophan
values (1,'Chăm sóc khách hàng'),
	   (2,'Lễ Tân'),
       (3,'Nhà Hàng'),
       (4,'Spa'),
       (5,'Buồng phòng');
       
insert into dichvudikem
values
(1,'Massage',50,1,'on'),
(2,'Karaoke',100,2,'on'),
(3,'Baverage',30,3,'on'),
(4,'Gym',70,4,'on'),
(5,'Car',120,5,'on');

insert into loaidichvu
values
(1,'Vip'),
(2,'Normal');

insert into kieuthue
values
(1,'Villa',300),
(2,'House',200),
(3,'Room',100);

insert into dichvu
values
(1,'Ẩm Thực',200,3,150,300,1,1,'on'),
(2,'Spa',100,2,30,200,1,2,'on'),
(3,'Gym',70,2,20,150,3,1,'on'),
(4,'Club',200,2,100,200,1,1,'on'),
(5,'Bar',100,0,60,100,3,2,'on');
                          
insert into loaikhach
values
(1,'Diamond'),
(2,'Platinium'),
(3,'Gold'),
(4,'Silver'),
(5,'Member');

insert into khachhang
values
(1,1,'Thắng','1988-07-13','123123123','0905123123','thang@gmail.com','Quảng Ngãi'),
(2,2,'Thông','1983-07-22','123123456','0905123456','thong@gmail.com','Quang Tri'),
(3,3,'Tinh','1992-05-11','123123789','0905123789','tinh@gmail.com','Đà Nẵng'),
(4,1,'Dung','1995-01-11','123456789','0905123654','dung@gmail.com','Quảng Trị'),
(5,1,'Quá','1991-12-22','456123456','0905456456','qua@gmail.com','Vinh'),
(6,1,'Quá','2000-01-11','789456123','0905159753','qua1@gmmail.com','Huế'),
(7,2,'Thông','1989-02-15','123123321','0905243156','thong1@gmail.com','Hà Nội');

insert into nhanvien
values
(1,'Kiên','1991-02-21','123456789',350,'0905123456','asda@gmai.com','13 Đống Đa',1,1,2),
(2,'Hân','1999-03-14','123879456',250,'0905123654','han@gmail.com','123 Đỗ Quang',2,2,3),
(3,'Thanh','1994-05-17','456123798',300,'0972151235','thanh@gmail.com','22 Lê Độ',2,2,4),
(4,'Dũng','1997-05-25','123123798',500,'0972151111','dung@gmail.com','22 3 tháng 2',4,1,3),
(5,'Dụng','1997-07-14','123123123',300,'0972151222','tiendung@gmail.com','22 Đống Đa',1,2,5),
(6,'Linh','1998-01-27','123123456',400,'0972151333','linh@gmail.com','22 Ngô Quyền',2,2,1),
(7,'Trường','1993-09-18','123123654',700,'0972151444','truong@gmail.com','22 2/9',4,1,3),
(8,'Linh','1997-02-09','123123789',400,'0972151555','linh1@gmail.com','22 Nguyễn Văn Linh',2,2,4),
(9,'Hậu','2000-01-18','123465456',300,'0972151445','hau@gmail.com','22 Đõ Bá',5,3,5),
(10,'Trúc','1993-09-22','123456465',300,'0972151446','truc@gmail.com','22 Bùi Tá Hán',5,3,5);



insert into hopdong
values
(1,2,1,1,'2019-01-11','2019-03-15',300,1000),
(2,3,2,2,'2019-02-15','2019-04-22',400,900),
(3,6,3,3,'2019-03-01','2019-05-11',400,1100),
(4,8,4,4,'2020-09-22','2020-11-11',450,1000),
(5,8,5,5,'2020-02-28','2020-04-22',300,800),
(6,2,1,1,'2020-01-11','2020-03-11',350,800),
(7,3,2,2,'2018-02-22','2018-04-22',250,650),
(8,6,3,3,'2018-03-31','2018-06-11',375,700);

insert into hopdongchitiet
values
(1,1,1,3),
(2,2,2,4),
(3,3,3,2),
(4,4,4,6),
(5,5,5,1);







