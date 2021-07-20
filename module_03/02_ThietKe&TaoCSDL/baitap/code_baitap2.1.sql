create database Code_MoHinhQuanHe;
use Code_MoHinhQuanHe;
CREATE TABLE NhaCC(
MaNCC int PRIMARY KEY AUTO_INCREMENT,
TenNCC VARCHAR(30) ,
DiaChi VARCHAR(30),
MaSDT INT
);
CREATE TABLE DonDH(
SoDH int PRIMARY KEY AUTO_INCREMENT,
NgayDH datetime
-- ma_ncc int,
-- FOREIGN KEY(ma_ncc)REFERENCES nha_cc(ma_ncc)
);
CREATE TABLE VATTU(
MaVTU INT PRIMARY KEY AUTO_INCREMENT,
TenVTU VARCHAR(30)
);
create table PhieuXuat(
SoPX int primary key auto_increment,
NgayXuat datetime,
MaVTU varchar(30)
);
create table PhieuNhap(
SoPN int primary key auto_increment,
NgayNhap datetime,
MaVTU varchar(30),
foreign key(MaVTU) references PhieuXuat(MaVTU)
);
