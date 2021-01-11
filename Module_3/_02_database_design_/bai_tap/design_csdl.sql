drop database if exists sales_manager;

create database sales_manager;

use sales_manager;

create table product_lines(
product_line varchar(50) not null primary key,
text_description varchar(50),
image varchar (50)
);

create table offices(
office_code varchar(10) not null primary key,
city varchar(50) not null,
phone varchar(50) not null,
address_line1 varchar(50) not null,
address_line2 varchar(50),
state varchar(50),
country varchar(50) not null,
postal_code varchar(15) not null
);

create table employees(
employee_number int not null primary key,
last_name varchar(50) not null,
first_name varchar(50) not null,
email varchar(100) not null,
job_title varchar(50) not null,
leader_id int,
offices_office_code varchar(10),

foreign key (leader_id) references employees (employee_number),
foreign key (offices_office_code) references offices (office_code)
);

create table customers(
customer_number int not null auto_increment primary key,
customer_name varchar(50) not null,
contact_last_name varchar(50) not null,
contact_first_name varchar(50) not null,
phone varchar(50) not null,
address_line1 varchar(50) not null,
address_line2 varchar(50),
city varchar(50) not null,
state varchar(50) not null,
postal_code varchar(50) not null,
country varchar(50) not null,
credit_limit int,
employees_employee_number int,

foreign key (employees_employee_number) references employees (employee_number)
);

create table products(
product_code varchar(15) not null primary key,
product_name varchar(70) not null,
product_scale varchar(10) not null,
product_vendor varchar(50) not null,
product_description text not null,
quantity_in_stock int not null,
buy_price double not null,
msrp double not null,
productlines_product_line varchar(50),

foreign key (productlines_product_line) references product_lines (product_line)
);

create table orders(
order_number int not null primary key,
order_date date not null,
required_date date not null,
shipped_date date not null,
status varchar(15) not null,
comments text,
quantity_ordered int not null,
price_each double not null,
customer_number int,

foreign key (customer_number) references customers(customer_number)
);

create table order_product(
products_product_code varchar(15) not null,
orders_order_number int not null,

primary key(products_product_code,orders_order_number),
foreign key (products_product_code) references products(product_code),
foreign key (orders_order_number) references orders (order_number)
);

create table payments(
check_number varchar(50) not null primary key,
payment_date date not null,
amount double not null,
customer_number int not null,

foreign key (customer_number) references customers(customer_number)
);

