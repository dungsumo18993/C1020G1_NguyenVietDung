create database design_database;

create table contacts (
contact_id int not null auto_increment,
birthday date,
constraint contact_pk primary key (contact_id)
);

CREATE TABLE suppliers
( supplier_id INT NOT NULL AUTO_INCREMENT,
  supplier_name VARCHAR(50) NOT NULL,
  account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
  CONSTRAINT suppliers_pk PRIMARY KEY (supplier_id)
);

drop table contacts;
drop table suppliers;

alter table contacts 
add last_name varchar(40) not null
after contact_id,
add first_name varchar(35) not null
after last_name;

alter table contacts
modify last_name varchar(50) null;

alter table contacts
drop column contact_id;

alter table contacts
change column last_name `name`
varchar(20) not null;

alter table contacts
rename to people;



