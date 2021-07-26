use case_study3;
-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
SET FOREIGN_KEY_CHECKS=0;
SET SQL_SAFE_UPDATES = 0;
delete  
from khach_hang
where id_khachhang in (
select  h.id_khachhang
from hop_dong h
where year(h.ngay_lam_hop_dong) < "2016");
SET FOREIGN_KEY_CHECKS=1;
-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
create temporary table test1(
select dvdk.id_dichvudikem , dvdk.gia_dichvudikem, hdct.so_luong,  sum(hdct.so_luong) as "so_lan_su_dung"
from dichvu_dikem dvdk
inner join hop_dong_chi_tiet hdct on hdct.id_dichvudikem = dvdk.id_dichvudikem
inner join hop_dong h on hdct.id_hopdong = h.id_hopdong
where year(h.ngay_lam_hop_dong)=2019
group by (id_dichvudikem));
select *
from test1;
update dichvu_dikem
set gia_dichvudikem = gia_dichvudikem * 2
where id_dichvudikem in (select id_dichvudikem from test1 where so_lan_su_dung >10);
drop table test1;
-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống,
-- thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
select n.id_nhanvien as id, n.hoten_nhanvien, n.email, n.sdt, n.ngaysinh, n.diachi
from nhan_vien n
union all
select k.id_khachhang, k.hoten_khach, k.email, k.sdt, k.ngay_sinh, k.dia_chi
from khach_hang k;
-- 21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Đà Nẵng”
-- và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”
create view V_NHANVIEN as
select n.id_nhanvien, n.hoten_nhanvien, n.id_vitri,n.id_trinhdo,n.id_bophan,n.ngaysinh,n.cmnd,n.luong,n.sdt,n.email,n.diachi
from nhan_vien n inner join hop_dong h on n.id_nhanvien = h.id_nhanvien
where h.ngay_lam_hop_dong = '2019/12/12'
group by id_nhanvien
having n.diachi like 'hải châu%';
-- 22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu”
-- đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
update nhan_vien
set diachi = 'Liên Chiểu, Đà Nẵng'
where id_nhanvien in (
select id_nhanvien from v_nhanvien
);
select * 
from nhan_vien;
-- 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó
-- với Id Khách hàng được truyền vào như là 1 tham số của Sp_1

SET FOREIGN_KEY_CHECKS=0;
drop procedure if exists sp_1;
DELIMITER //
create procedure sp_1 (in id_khach int)
begin
	delete 
    from khach_hang
    where id_khachhang = id_khach;
end
// DELIMITER ;
call sp_1(6);
select *
from khach_hang;
drop view v_nhanvien;
-- 24.	Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải thực hiện
-- kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và
-- đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
drop procedure if exists sp_2;
DELIMITER //
create procedure sp_2 (id_hd int,id_nv int,id_kh int,id_dv int,ngay_lam_hd datetime,ngay_kt datetime,tien_dc int,tong int)
begin
if id_hd in (select id_hopdong from hop_dong) then
if id_nv in (select id_nhanvien from nhan_vien) then
if id_kh in (select id_khachhang from khach_hang) then
if id_dv in (select id_dichvu from dich_vu)
then 
insert into hop_dong(id_hopdong,id_nhanvien,id_khachhang,id_dichvu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,tong_tien)
values(id_hd,id_nv,id_kh,id_dv,ngay_lam_hd,ngay_kt,tien_dc,tong);
else select concat(id_hd,"id_hd không có trong hệ thống") as "error" ;
end if;
else select concat(id_dv,"id_dv không có trong hệ thống") as "error" ;
end if;
else select concat(id_kh," id_kh không có trong hệ thống") as "error";
end if;
else select concat(id_nv,"id_nv không có trong hệ thống") as "error";
end if;
end
// DELIMITER ;
call sp_2 (3,7,9,1,'2019/10/1','2019/12/5',1000000,13000000);
select* from hop_dong;
drop procedure sp_2;
-- 25.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng số lượng bản ghi còn lại
-- có trong bảng HopDong ra giao diện console của database
set @result =0;
 delimiter //
 create trigger tr_1
 after delete
 on hop_dong for each row
 begin
set @result =  (select count(id_hopdong)
				from hop_dong);
 end //
 delimiter ;
 delete
 from hop_dong
 where id_hopdong =1;
 select @result;
 drop trigger tr_1
