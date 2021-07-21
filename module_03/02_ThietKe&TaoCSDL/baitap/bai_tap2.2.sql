drop database if exists quanlybanhang;
create database QuanLyBanHang;
use quanlybanhang;
create table Customer(
Customer_Id int primary key auto_increment,
Customer_Name varchar(30),
Customer_Age int
);
create table `order`(
Order_Id int primary key auto_increment,
Customer_Id int,
foreign key (Customer_Id) references Customer(Customer_Id),
Order_date datetime,
Total_Price int);
create table Order_Detail(
Order_Id int ,

Product_Id int,
primary key(order_id,product_id),
order_QTY int);
create table Product(
Product_Id int primary key auto_increment,
-- foreign key (ProductId) references OrderDetail(ProductId),
Product_Name varchar(30),
Product_Price int
);
ALTER TABLE Order_Detail ADD CONSTRAINT FK_Product FOREIGN KEY (Product_Id) REFERENCES Product(Product_ID);
