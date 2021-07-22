use case_study3;
-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K”
-- và có tối đa 15 ký tự.
select *
from nhan_vien
where(    -- SUBSTRING_INDEX( string, delimiter, number ) = àh
right(substring_index(reverse(hoten_nhanvien), " ", 1),1) = 'H' or
right(substring_index(reverse(hoten_nhanvien), " ", 1),1) = 'K' or
right(substring_index(reverse(hoten_nhanvien), " ", 1),1) = 'T') and length(hoten_nhanvien)<=15;

-- 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi
-- và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select*,timestampdiff(year,ngay_sinh,current_date())  as tuoi
from khach_hang
where ( timestampdiff(year,ngay_sinh,current_date()) between 18 and 50) and dia_chi in ("Đà Nẵng","Quảng Trị");
-- 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select k.id_khachhang,k.hoten_khach,count(h.id_hopdong)
from khach_hang k 
join hop_dong h
on k.id_khachhang =h.id_khachhang
where id_loaikhach = 1                                 -- Tên loại khách hàng là “Diamond”
group by k.id_khachhang
order by count(h.id_hopdong) asc;

-- 5.Hiển thị IDKhachHang, HoTen, TenLoaiKhach,
-- IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, 
-- TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia,
-- với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng. 
-- Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra.
select k.id_khachhang, k.hoten_khach, l.ten_loaikhach, h.id_hopdong, d.ten_dichvu, h.ngay_lam_hop_dong, h.ngay_ket_thuc,sum( chi_phi_thue + dvdk.gia_dichvudikem * hdct.so_luong) as tongtien
from (((((khach_hang k 
left join loai_khach l on k.id_loaikhach = l.id_loaikhach)
left join hop_dong h on k.id_khachhang = h.id_khachhang)
left join dich_vu d on  h.id_dichvu = d.id_dichvu)
left join hop_dong_chi_tiet hdct on h.id_hopdong = hdct.id_hopdong)
left join dichvu_dikem dvdk on hdct.id_dichvudikem = dvdk.id_dichvudikem)
 group by id_khachhang;
 
 -- 6.Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng
 -- được Khách hàng thực hiện đặt từ quý 1 của năm 2019 
 select d.id_dichvu, d.ten_dichvu, d.dien_tich, d.chi_phi_thue, lvd.ten_loaidvu, h.ngay_lam_hop_dong
 from dich_vu d
 join loai_dvu lvd on d.id_loaidvu = lvd.id_loaidvu
 join hop_dong h on h.id_dichvu = d.id_dichvu
 where not (year(ngay_lam_hop_dong)= 2019 and month(ngay_lam_hop_dong) between 1 and 3);
 
 -- cách 2, dùng not exitsts

select d.id_dichvu, d.ten_dichvu, d.dien_tich, d.chi_phi_thue, lvd.ten_loaidvu, h.ngay_lam_hop_dong
 from dich_vu d
 join loai_dvu lvd on d.id_loaidvu = lvd.id_loaidvu
 join hop_dong h on h.id_dichvu = d.id_dichvu
where not exists (
select * 
from hop_dong h where h.id_dichvu = d.id_dichvu
and year(ngay_lam_hop_dong)= 2019 and month(ngay_lam_hop_dong) between 1 and 3);
 
 -- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại
 -- dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018
 -- nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
  select d.id_dichvu, d.ten_dichvu, d.dien_tich, d.chi_phi_thue, lvd.ten_loaidvu, h.ngay_lam_hop_dong
 from dich_vu d
 join loai_dvu lvd on d.id_loaidvu = lvd.id_loaidvu
 join hop_dong h on h.id_dichvu = d.id_dichvu
 where year(ngay_lam_hop_dong)= 2018 ;
 
 -- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
-- cách 1, dùng union
select hoten_khach
from khach_hang
union
select hoten_khach
from khach_hang;
-- cách 2, dùng distinct
select distinct hoten_khach
from khach_hang;
-- cách 3, gộp bằng group by
select hoten_khach
from khach_hang
group by hoten_khach;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì
-- sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(h.ngay_lam_hop_dong) as thang , count(h.id_hopdong) as so_hop_dong
from hop_dong h
where year(h.ngay_lam_hop_dong) = "2019"
group by month(h.ngay_lam_hop_dong);
-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem
-- (được tính dựa trên việc count các IDHopDongChiTiet).
select h.id_hopdong, h.ngay_lam_hop_dong, h.ngay_ket_thuc, h.tien_dat_coc, hdct.so_luong, count(id_hop_dong_chi_tiet)
from hop_dong h
join hop_dong_chi_tiet hdct on h.id_hopdong = hdct.id_hopdong
group by id_hopdong;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang
-- là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select k.id_khachhang,k.hoten_khach, l.ten_loaikhach, k.dia_chi,dvdk.id_dichvudikem,ten_dichvudikem
from ((((khach_hang k
join loai_khach l on k.id_loaikhach = l.id_loaikhach)
join hop_dong h on h.id_khachhang = k.id_khachhang)
join hop_dong_chi_tiet hdct on hdct.id_hopdong = h.id_hopdong)
join dichvu_dikem dvdk on dvdk.id_dichvudikem = hdct.id_dichvudikem)
where l.ten_loaikhach = 'Diamond' and k.dia_chi in ('Vinh','Quảng Ngãi');
 
-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang,
-- TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết),
-- TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019

select h.id_hopdong, n.hoten_nhanvien, k.hoten_khach, k.sdt, d.ten_dichvu, hdct.so_luong,h.ngay_lam_hop_dong, tien_dat_coc
from ((((nhan_vien n
join hop_dong h on n.id_nhanvien = h.id_nhanvien)
join khach_hang k on h.id_khachhang = k.id_khachhang)
join dich_vu d on h.id_dichvu = d.id_dichvu)
join hop_dong_chi_tiet hdct on hdct.id_hopdong = h.id_hopdong)
where month(ngay_lam_hop_dong) between 10 and 12;

-- 13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
-- x.join dvdk và hdct lại. group by(id_dvdk) ,count (id_hdct), dùng  count(id_hdct) >= all (select count(id_hdct)
