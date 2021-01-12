drop database if exists book_management;

create database book_management;

use book_management;

create table borrow_orders (
borrow_order_id int not null primary key,
date_brrowed date,
pay_day date
);

create table categorys (
category_id int not null primary key,
category_name varchar(50)
);

create table books (
book_id int not null primary key,
book_name varchar(50),
categorys_category_id int,

foreign key (categorys_category_id) references categorys (category_id)
);

create table brrows_book (
borrow_order_id int not null,
books_book_id int not null,
primary key (borrow_order_id, books_book_id),

foreign key (borrow_order_id) references borrow_orders (borrow_order_id),
foreign key (books_book_id) references books (book_id)
);

create table students (
student_number int not null primary key,
student_name varchar(50),
address varchar(500),
email varchar(50) unique,
image text,
borrow_order_id int,

foreign key (borrow_order_id) references borrow_orders (borrow_order_id)
);
