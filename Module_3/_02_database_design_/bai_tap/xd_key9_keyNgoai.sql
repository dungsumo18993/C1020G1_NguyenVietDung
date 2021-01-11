create database bank_management;

use bank_management;

create table customers(
customer_number int not null auto_increment,
full_name varchar(50),
adress varchar(50),
email varchar(50),
phone varchar(10),
primary key (customer_number)

);

create table accounts(
account_number int not null auto_increment,
account_type varchar(50) not null,
`date` date,
balance int,
customers_customer_number int,

primary key (account_number),
foreign key (customers_customer_number) references customers(customer_number)
);

create table transactions(
tran_number int not null auto_increment,
`date` date,
amounts varchar(50),
descriptions varchar(50),
accounts_account_number int,

primary key (tran_number),
foreign key (accounts_account_number) references accounts(account_number)
);