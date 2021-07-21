drop database if exists case_study3;
create database case_study3;
use case_study3;
create table vi_tri(
id_vitri int primary key,
ten_vitri varchar(45)
);
insert into vi_tri(id_vitri,ten_vitri)
values(1,'lễ tân'),
(2,'phục vụ'),
(3,'chuyên viên'),
(4,'giám sát'),
(5,'quản lý'),
(6,'giám đốc');

create table trinh_do(
id_trinhdo int primary key,
ten_trinhdo varchar(45)
);
insert into trinh_do(id_trinhdo,ten_trinhdo)
values(1,'trung cấp'),
(2,'cao đẳng'),
(3,'đại học'),
(4,'sau đại học');

create table bo_phan(
id_bophan int primary key,
ten_bophan varchar(45)
);
insert into bo_phan(id_bophan,ten_bophan)
values(1,'sale-markerting'),
(2,'hành chính'),
(3,'phục vụ'),
(4,'quản lý');

create table dichvu_dikem(
id_dichvudikem int primary key,
ten_dichvudikem varchar(45),
gia_dichvudikem int,
donvi int,
trangthakhadung varchar(45)
);
insert into dichvu_dikem(id_dichvudikem,ten_dichvudikem,gia_dichvudikem,donvi,trangthakhadung)
values(1,'massage',1000,1,'co'),
(2,'karaoke',2000,2,'không'),
(3,'ăn uống',3000,3,'co'),
(4,'thuê xe',4000,4,'không');

create table loai_dvu(
id_loaidvu int primary key,
ten_loaidvu varchar(45)
);
insert into loai_dvu(id_loaidvu,ten_loaidvu)
values(1,'villa'),
(2,'house'),
(3,'room');

create table kieu_thue(
id_kieuthue int primary key,
ten_kieuthue varchar(45),
gia int
);
insert into kieu_thue(id_kieuthue,ten_kieuthue,gia)
values(1,'ngày',1000),
(2,'tuần',2000),
(3,'tháng',3000);

create table loai_khach(
id_loaikhach int primary key,
ten_loaikhach varchar(45)
);
insert into loai_khach (id_loaikhach,ten_loaikhach)
values (1,'Diamond'),
(2,'Platinium'),
(3,'Gold'),
(4,'Silver'),
(5,'Member');

create table nhan_vien(
id_nhanvien int primary key,
hoten_nhanvien varchar (45),
id_vitri int,
foreign key(id_vitri) references vi_tri(id_vitri),
id_trinhdo int,
foreign key(id_trinhdo) references trinh_do(id_trinhdo),
id_bophan int,
foreign key(id_bophan) references bo_phan(id_bophan),
ngaysinh datetime,
cmnd varchar(45),
luong varchar(45),
sdt varchar(45),
email varchar(45),
diachi varchar(45)
);
insert into nhan_vien(id_nhanvien,hoten_nhanvien,id_vitri,id_trinhdo,id_bophan,ngaysinh,cmnd,luong,sdt,email,diachi)
values(1,'lê văn diệp',6,4,4,'1991/4/15','111111111','10000','0987654321','vandiep@gmail.com','QT'),
(2,'nguyễn thanh hà',5,3,4,'1996/6/15','222222222','9000','0987098765','thanhha@gmail.com','DL'),
(3,'đồng văn nhật',3,2,4,'1998/12/9','333333333','8000','0987654321','vannhat@gmail.com','QT'),
(4,'hồ kỳ tài',1,4,1,'1999/12/15','444444444','7000','0987827262','kytai@gmail.com','DN'),
(5,'nguyễn khắc phụt',3,1,4,'1991/4/3','555555555','6000','0987927261','khacphuc@gmail.com','DN'),
(6,'nguyễn văn đức',4,4,4,'1995/9/15','666666666','5000','0989282722','vanduc@gmail.com','HN'),
(7,'đặng nhật linh',2,4,1,'1997/10/15','777777777','4000','0987628121','nhatlinh@gmail.com','QT'),
(8,'trương a quân',2,3,3,'1991/1/1','888888888','3000','0987271222','aquan@gmail.com','HUE'),
(9,'trần minh chiến',1,1,1,'1998/1/30','999999999','2000','0912292733','minhchien@gmail.com','DL'),
(10,'tuấn kiệt',3,4,1,'1992/4/15','123456789','1000','0900000122','vankiet@gmail.com','DN');

create table khach_hang(
id_khachhang int primary key,
id_loaikhach int,
foreign key(id_loaikhach) references loai_khach(id_loaikhach),
hoten_khach varchar(45),
ngaysinh datetime,
cmnd varchar(45),
sdt varchar(45),
email varchar(45),
diachi varchar(45)
);
insert into khach_hang(id_khachhang,id_loaikhach,hoten_khach,ngaysinh,cmnd,sdt,email,diachi)
values(1,5,'john biden', '1987/12/12','2516228292','02123234','biden@gmail.com','america'),
(2,3,'jeff bezos', '1967/12/6','643322222','09877655578','jezz@gmail.com','america'),
(3,1,'Elon Musk', '1985/4/23','234567788','009865545','elon@gmail.com','england'),
(4,2,'Bill Gates', '1947/1/2','2244211123','076543354','bill@gmail.com','germany'),
(5,4,'Mark Zuckerberg', '1933/12/5','7544213566','0765443334','mark@gmail.com','america'),
(6,5,'Warren Buffett', '1987/10/30','654455667','029876557','waren@gmail.com','endland'),
(7,2,'jack ma', '1981/11/12','644456677','028776556','jackma@gmail.com','china');

create table dich_vu(
id_dichvu int primary key,
ten_dichvu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da int,
chi_phi_thue int,
id_kieuthue int,
foreign key(id_kieuthue) references kieu_thue(ID_kieuthue),
id_loaidvu int,
foreign key(id_loaidvu) references loai_dvu(id_loaidvu),
trang_thai varchar(45)
);
insert into dich_vu(id_dichvu, ten_dichvu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, id_kieuthue, id_loaidvu, trang_thai)
values(1,'room_a',10,5,5,100,1,3,'co'),
(2,'room_b',10,5,5,100,1,3,'co'),
(3,'room_c',10,5,5,100,1,3,'không'),
(4,'house_a',20,10,15,200,2,2,'co'),
(5,'house_b',20,10,15,200,2,2,'không'),
(6,'house_c',20,10,15,200,2,2,'co'),
(7,'villa_a',30,15,25,300,3,1,'không'),
(8,'villa_b',30,15,25,300,3,1,'co'),
(9,'villa_c',30,15,25,300,3,1,'co');

create table hop_dong(
id_hopdong int primary key,
id_nhanvien int,
foreign key (id_nhanvien) references nhan_vien(id_nhanvien),
id_khachhang int,
foreign key(id_khachhang) references khach_hang(id_khachhang),
id_dichvu int,
foreign key(id_dichvu) references dich_vu(id_dichvu),
ngay_lam_hop_dong datetime,
ngay_ket_thuc datetime,
tien_dat_coc int,
tong_tien int null
);
insert into hop_dong(id_hopdong,id_nhanvien,id_khachhang,id_dichvu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,tong_tien)
values(1,1,1,9,'2019/1/1','2019/1/5',100,300),
(2,2,2,8,'2018/1/11','2019/1/20',100,300),
(3,3,3,7,'2019/1/19','2019/4/5',100,300),
(4,4,4,6,'2020/1/1','2019/1/25',20,200),
(5,5,5,3,'2019/4/1','2019/6/5',10,100),
(6,6,6,2,'2019/1/1','2020/1/1',10,100),
(7,7,7,1,'2019/1/8','2019/1/25',10,100);

create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int primary key,
id_hopdong int,
foreign key(id_hopdong) references hop_dong(id_hopdong),
id_dichvudikem int,
foreign key(id_dichvudikem) references dichvu_dikem(id_dichvudikem),
so_luong int
);
insert into hop_dong_chi_tiet(id_hop_dong_chi_tiet, id_hopdong, id_dichvudikem, so_luong)
values(1,1,4,2),
(2,2,3,1),
(3,3,1,2),
(4,4,3,3),
(5,5,2,5),
(6,6,4,1),
(7,7,1,2)





