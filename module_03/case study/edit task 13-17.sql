use case_study3;
-- 13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
-- join dvdk và hdct lại. group by(id_dvdk) ,count (id_hdct), dùng  count(id_hdct) >= all (select count(id_hdct)
-- hiển thị khách hàng nhiều sluong hdct nhất
select dvdk.ten_dichvudikem, dvdk.id_dichvudikem,dvdk.gia_dichvudikem,dvdk.donvi,sum(hdct.so_luong) as soluong_hdct
from hop_dong_chi_tiet hdct
join dichvu_dikem dvdk on dvdk.id_dichvudikem = hdct.id_dichvudikem
group by hdct.id_dichvudikem                                        -- tách hdct.soluong ra riêng
having sum(hdct.so_luong) >= all(select sum(so_luong)
                                  from hop_dong_chi_tiet
                                  group by id_dichvudikem);
-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
select h.id_hopdong,lvd.ten_loaidvu,dvdk.ten_dichvudikem,count(hdct.so_luong) as soluong_hdct
from (((hop_dong h
join dich_vu d on h.id_dichvu = d.id_dichvu)
join loai_dvu lvd on d.id_loaidvu = lvd.id_loaidvu)
join hop_dong_chi_tiet hdct on hdct.id_hopdong = h.id_hopdong)
join dichvu_dikem dvdk on dvdk.id_dichvudikem = hdct.id_dichvudikem
group by dvdk.id_dichvudikem
having count(hdct.so_luong)=1;
-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
select n.id_nhanvien, n.hoten_nhanvien, n.id_trinhdo,n.id_bophan, n.sdt,n.diachi, count(h.ngay_lam_hop_dong) as so_hd
from nhan_vien n
join hop_dong h on n.id_nhanvien = h.id_nhanvien
where year(h.ngay_lam_hop_dong) in (2018,2019)
group by h.id_nhanvien
having count(h.ngay_lam_hop_dong) <= 3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
SET FOREIGN_KEY_CHECKS=0;
SET SQL_SAFE_UPDATES = 0;
delete from nhan_vien n
where n.id_nhanvien not in (select h.id_nhanvien
				              from hop_dong h
				              where (year(h.ngay_lam_hop_dong) between 2017 and 2019)
                               );
SET FOREIGN_KEY_CHECKS=1;
-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond,
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.
create temporary table test(
select k.id_khachhang, sum( d.chi_phi_thue + dvdk.gia_dichvudikem * hdct.so_luong) as tongtien
from (((khach_hang k 
join hop_dong h on h.id_khachhang = k.id_khachhang)
join dich_vu d on h.id_dichvu = d.id_dichvu)
join hop_dong_chi_tiet hdct on hdct.id_hopdong = h.id_hopdong)
join dichvu_dikem dvdk on dvdk.id_dichvudikem = hdct.id_dichvudikem
where year(h.ngay_lam_hop_dong) = 2019 
group by k.id_khachhang
having tongtien > 10000000
);
select *
from test;
update khach_hang
set id_loaikhach = 1
where id_khachhang in (
select id_khachhang 
from test) 
and id_loaikhach =2;
drop table test; 



