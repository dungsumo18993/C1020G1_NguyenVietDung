drop database if exists index_view_sp;

create database index_view_sp;

use index_view_sp;

create table products (
id int,
product_code varchar(10),
product_name varchar(50),
product_price double,
product_amount int,
product_description varchar(50),
product_status varchar(10)
);

insert into products 
values
(1,'A1234','R1M',800,100,'pretty','new'),
(2,'B1234','H2R',1200,50,'pretty','new'),
(3,'C1234','Z-1000k',900,40,'nice','old'),
(4,'D1234','CBR1000',850,30,'nice','old'),
(5,'E1234','BMW',750,20,'pretty','new');

explain select *
 from products
 where product_code = 'C1234';
 
create unique index idx_product on products (product_code);

explain select product_code
 from products
 where product_code = 'C1234';
 
-- alter table products drop index idx_name_price;
 
 create index idx_name_price on products (product_name, product_price);
 
explain select *
 from products
 where product_name = 'H2R' or product_name = 'BMW';
 alter table products drop index idx_name_price;
 
 -- Bước 4:
 create view view_products as
 select product_code, product_name, product_price, product_status
 from products;
 
select * from view_products;

create or replace view view_products as
select product_code, product_name, product_price, product_amount, product_description
from products;

select * from view_products;

-- Bước 5:
delimiter //
create procedure find_all_product()
begin
select *
from products;
end;
// delimiter ;

call find_all_product();

delimiter //
create procedure add_new_product(
id int,
product_code varchar(10),
product_name varchar(50),
product_price double,
product_amount int,
product_description varchar(50),
product_status varchar(10)
 )
begin
insert into products
value
(id, product_code, product_name, product_price, product_amount, product_description, product_status);
end;
// delimiter ;

call add_new_product(6,'A4321','Z-800',400,20,'nice','new');

delimiter //
create procedure repair_products(p_keyword varchar(50), id int)
begin
update products
set product_name = p_keyword
where products.id = id;
end;
// delimiter ;

call repair_products('H3',2);
drop procedure repair_products;

delimiter //
create procedure delete_products(id int)
begin
delete from products
where products.id = id;
end;
// delimiter ;

call delete_products(1);