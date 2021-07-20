create database QuanLyBanHang;
use quanlybanhang;
create table Customer(
CustomerId int primary key auto_increment,
CustomerName varchar(30),
CustomerAge int
);
create table `order`(
OrderId int primary key auto_increment,
CustomerId int,
foreign key (CustomerId) references Customer(CustomerId),
Orderdate datetime,
TotalPrice int);
create table OrderDetail(
OrderId int primary key auto_increment,
foreign key (OrderId) references `Order`(OrderId),
ProductId int,
orderQTY int);
create table Product(
ProductId int primary key auto_increment,
-- foreign key (ProductId) references OrderDetail(ProductId),
ProductName varchar(30),
ProductPrice int
);
ALTER TABLE OrderDetail ADD CONSTRAINT FK_Product FOREIGN KEY (ProductId) REFERENCES Product(ProductID);
-- drop database quanlybanhang