create database QuanLyDiemThi;
use QuanLyDiemThi;
-- HocSinh(MaHS, TenHS, NgaySinh, Lop, GT)
create table HocSinh(
MaHS varchar(30) primary key,
TenHS varchar(30),
NgaySinh datetime,
Lop varchar(30),
GT varchar(30)
);
-- ALTER TABLE HocSinh
--     ADD PRIMARY KEY(MaHS);
-- MonHoc(MaMH, TenMH, MaGV)
CREATE TABLE MonHoc(
    MaMH VARCHAR(20) PRIMARY KEY,
    TenMH VARCHAR(50)
);
-- MaGV varchar(30));
-- BangDiem(MaHS, MaMH, DiemThi, NgayKT)
create table BangDiem(
MaHS varchar(30),
MaMH varchar(30),
DiemThi INT,
NgayKT DATETIME,
primary key(MaHS, MaMH),
foreign key (MaHS) references HocSinh(MaHS),
foreign key (MaMH) references MonHoc(MaMH)
);
-- GiaoVien(MaGV, TenGV, SDT)
create table GiaoVien(
 MaGV varchar(30) primary key,
    TenGV varchar(30),
    SDT varchar(10)
);
alter table monhoc add MaGV varchar(30);
alter table monhoc add constraint FK_MaGV foreign key (MaGV) references GiaoVien(MaGV);


