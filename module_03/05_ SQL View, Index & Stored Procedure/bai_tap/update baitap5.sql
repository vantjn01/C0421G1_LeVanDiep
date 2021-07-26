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
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view product_view as 
select p.product_code, p.product_name, p.product_price, p.product_status
from products p;
-- Tiến hành sửa đổi view
update product_view
set product_status = "đang bán"
where product_code = "sp3";
drop view product_view;
-- Bước 5:
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
drop procedure if exists demo;
DELIMITER //
create procedure demo()
begin
select *
from products;
end
//delimiter ;
call demo();
-- Tạo store procedure thêm một sản phẩm mới
drop procedure if exists new_demo;
delimiter // 
create procedure new_demo(
new_product_code varchar(30),
new_product_name varchar(30),
new_product_price int,
new_product_amount int,
new_product_description varchar(30),
new_product_status varchar(30)
)
begin
insert into products (product_code, product_name, product_price, product_amount, product_description, product_status)
    values (new_product_code, new_product_name, new_product_price, new_product_amount, new_product_description, new_product_status);
    
end
// DELIMITER ;
call new_demo('sp5', 'sứa', 22, 10, 'tươi rói', 'đang bán');
-- Tạo store procedure sửa thông tin sản phẩm theo id
drop procedure if exists change_demo;
DELIMITER //
create procedure change_demo (id_product int, new_product_status varchar(30))
begin
	update products
    set product_status = new_product_status
    where id = id_product;
end
// DELIMITER ;
call change_demo(1, 'hết hàng');
-- Tạo store procedure xoá sản phẩm theo id
drop procedure if exists delete_demo;
DELIMITER //
create procedure delete_demo (in id_product int)
begin
	delete 
    from products
    where id = id_product;
end
// DELIMITER ;
call delete_demo(5);
select *
from products

