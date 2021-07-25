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

