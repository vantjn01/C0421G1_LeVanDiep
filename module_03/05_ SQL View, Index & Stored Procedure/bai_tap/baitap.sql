-- Bước 1: Tạo cơ sở dữ liệu demo
drop database if exists demo;
create database demo;
use demo;
-- Bước 2: Tạo bảng Products với các trường dữ liệu sau:
create table products(
id int not null primary key auto_increment,
product_Code varchar(30),
product_Name varchar(30),
product_Price int,
product_Amount int,
product_Description varchar(30),
product_Status varchar(30)
);
insert into Products(id,product_code,product_name,product_price,product_amount,product_description,product_status)
values (1,"sp1","cá",20,10,"tươi rói","còn hàng"),
(2,"sp2","tôm",100,7,"vẫn còn nhảy","còn hàng"),
(3,"sp3","mực",13,3,"ươn mnr","hết hàng"),
(4,"sp4","ghẹ",9,1,"còn sống","đang bán");
-- Bước 3:
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create unique index product_index on products(product_code);
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index index_name_price on products(product_name, product_price);
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select * from products
where product_name = "cá";
-- Bước 4: