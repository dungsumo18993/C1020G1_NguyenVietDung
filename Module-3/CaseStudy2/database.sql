drop database if exists furama2;

create database furama2;

use furama2;

create table position (
position_id int auto_increment primary key,
position_name varchar (45)
);

create table education_degree (
education_degree_id int auto_increment primary key,
education_degree_name varchar (45)
);

create table division (
division_id int auto_increment primary key,
division_name varchar (45)
);

create table role (
role_id int auto_increment primary key,
role_name varchar(45)
);

create table user (
username varchar(255) primary key,
password varchar(255)
);

create table user_role (
role_id int,
username varchar(255),

foreign key (role_id) references role (role_id),
foreign key (username) references user (username)
);

create table employee (
employee_id int auto_increment primary key,
employee_name varchar(50),
employee_birthday date,
employee_id_card varchar(50),
employee_salary double,
employee_phone varchar(45),
employee_email varchar(45),
employee_address varchar (45),
username varchar (255),
position_id int,
education_degree_id int,
division_id int,

foreign key (position_id) references position (position_id)
on delete cascade,
foreign key (education_degree_id) references education_degree (education_degree_id)
on delete cascade,
foreign key (division_id) references division (division_id)
on delete cascade
);

create table customer_type (
customer_type_id int primary key,
customer_type_name varchar(45)
);

create table customer (
customer_id int auto_increment primary key,
customer_name varchar (45),
customer_birthday date,
customer_gender varchar(45),
customer_id_card varchar(45),
customer_phone varchar(45),
customer_email varchar(45),
customer_address varchar(45),
customer_type_id int,

foreign key (customer_type_id) references customer_type (customer_type_id)
on delete cascade
);

create table rent_type (
rent_type_id int auto_increment primary key,
rent_type_name varchar(45),
rent_type_cost double
);

create table service_type(
service_type_id int auto_increment primary key,
service_type_name varchar(45)
);

create table service (
service_id int auto_increment primary key,
service_name varchar(45),
service_area int,
service_cost double,
service_max_people int,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int,
rent_type_id int,
service_type_id int,

foreign key (rent_type_id) references rent_type (rent_type_id)
on delete cascade,
foreign key (service_type_id) references service_type (service_type_id)
on delete cascade
);

create table contract (
contract_id int auto_increment primary key,
contract_start_date datetime,
contract_end_date datetime,
contract_deposit double,
contract_total_money double,
employee_id int,
customer_id int,
service_id int,

foreign key (employee_id) references employee (employee_id)
on delete cascade,
foreign key (customer_id) references customer (customer_id)
on delete cascade,
foreign key (service_id) references service (service_id)
on delete cascade
);

create table attach_service (
attach_service_id int auto_increment primary key,
attach_service_name varchar(45),
attach_service_cost double,
attach_service_unit int,
attach_service_status varchar(45)
);

create table contract_detail (
contract_detail_id int auto_increment primary key,
quantity int,
contract_id int,
attach_service_id int,

foreign key (contract_id) references contract (contract_id)
on delete cascade,
foreign key (attach_service_id) references attach_service (attach_service_id)
on delete cascade
);

insert into position 
values (1,"Lễ tân"),
		(2,"Phục vụ"),
        (3,"Chuyên viên"),
        (4,"Giám sát"),
        (5,"Quản Lý"),
        (6,"Giám đốc");
        
insert into education_degree
values (1,"Trung Cấp"),
		(2,"Cao Đẳng"),
        (3,"Đại Học"),
        (4,"Sau đại học");
        
insert into division
values (1,"Sale-Marketing"),
		(2,"Hành Chính"),
        (3,"Phục Vụ"),
        (4,"Quản Lý");
        
insert into attach_service
values (1,'Massage',50,1,'on'),
		(2,'Karaoke',100,2,'on'),
		(3,'Foot',30,3,'on'),
		(4,'Drinks',70,4,'on'),
		(5,'Car',120,5,'on');
        
insert into service_type
values (1,"Vip"),
		(2,"Normal");
        
insert into rent_type
values (1,'Villa',300),
		(2,'House',200),
		(3,'Room',100);
        
insert into service
values (1,"Golf",500,100,50,"vip","no",50,3,1,1),
		(2,"Spa",100,50,30,"vip","no",30,2,3,1),
        (3,"Gym",100,30,20,"vip","no",25,2,1,2),
        (4,"Bar",200,50,100,"vip","no",0,2,1,1),
        (5,"BBQ",200,20,100,"vip","no",20,1,2,2);
        
insert into customer_type
values (1,'Diamond'),
		(2,'Platinium'),
		(3,'Gold'),
		(4,'Silver'),
		(5,'Member');
        
insert into customer
values (1,'Thắng','1988-07-13',"Male",'123123123','0905123123','thang@gmail.com','Quảng Ngãi',1),
		(2,'Thông','1983-07-22',"Male",'123123456','0905123456','thong@gmail.com','Quang Tri',1),
		(3,'Tình','1992-05-11',"Female",'123123789','0905123789','tinh@gmail.com','Đà Nẵng',2),
		(4,'Dung','1995-01-11',"Female",'123456789','0905123654','dung@gmail.com','Quảng Trị',2),
		(5,'Quá','1991-12-22',"Male",'456123456','0905456456','qua@gmail.com','Vinh',3),
		(6,'Hưng','2000-01-11',"Male",'789456123','0905159753','hưng@gmmail.com','Huế',3),
		(7,'Trinh','1989-02-15',"Female",'123123321','0905243156','thong1@gmail.com','Hà Nội',4),
		(8,'Quỳnh','2000-01-11',"Female",'789456155','0905159754','quynh@gmmail.com','Hồ Chí Minh',4),
        (9,'Thư','2000-01-11',"Female",'789456166','0905159755','thu@gmmail.com','Đà Nẵng',5),
        (10,'Hiếu','2000-01-11',"Male",'789456177','0905159756','hieu@gmmail.com','Vinh',5);

insert into employee
values (1,'Kiên','1991-02-21','123456789',350,'0905123456','kien@gmai.com','Đà Nẵng',"kien1991",1,2,2),
		(2,'Hân','1999-03-14','123879456',250,'0905123654','han@gmail.com','Quảng Trị',"han1999",2,1,3),
		(3,'Thanh','1994-05-17','456123798',300,'0972151235','thanh@gmail.com','Huế',"thanh1994",3,3,1),
		(4,'Dũng','1993-05-25','123123798',500,'0972151111','dung@gmail.com','Đà Nẵng',"dung1993",6,4,2),
		(5,'Dụng','1995-07-14','123123123',300,'0972151222','tiendung@gmail.com','Vinh',"dung1995",4,3,4),
		(6,'Linh','1998-01-27','123123456',400,'0972151333','linh@gmail.com','Hải Dương',"linh1998",2,2,3),
		(7,'Trường','1993-09-18','123123654',700,'0972151444','truong@gmail.com','Hà Nội',"truong1993",5,3,4),
		(8,'Linh','1997-02-09','123123789',400,'0972151555','linh1@gmail.com','Vinh',"linh1997",1,2,2),
		(9,'Hậu','2000-01-18','123465456',300,'0972151445','hau@gmail.com','Quảng Nam',"hau2000",2,2,3),
		(10,'Trúc','1993-09-22','123456465',300,'0972151446','truc@gmail.com','Nha Trang',"truc1993",5,3,4);
        
insert into contract
values (1,'2019-01-11','2019-03-15',300,1000,2,1,1),
		(2,'2019-02-15','2019-04-22',400,900,3,2,2),
		(3,'2019-03-01','2019-05-11',400,1100,6,3,3),
		(4,'2020-09-22','2020-11-11',450,1000,8,4,4),
		(5,'2020-02-28','2020-04-22',300,800,8,5,5),
		(6,'2020-01-11','2020-03-11',350,800,2,1,1),
		(7,'2018-02-22','2018-04-22',250,650,3,2,2),
		(8,'2018-03-31','2018-06-11',375,700,6,3,3);
        
insert into contract_detail
values (1,3,1,1),
		(2,4,2,2),
        (3,2,3,3),
        (4,6,4,4),
        (5,1,5,5),
        (6,3,6,2),
        (7,5,7,4),
        (8,2,8,5);

select e.employee_id, e.employee_birthday, e.employee_id_card, e.employee_salary, e.employee_phone, e.employee_email, e.employee_address, e.username, `position`.position_name, education_degree.education_degree_name, division.division_name
from employee e 
join `position` on e.position_id = `position`.position_id
join education_degree on e.education_degree_id = education_degree.education_degree_id
join division on e.division_id = division.division_id
where e.employee_name = "john1";