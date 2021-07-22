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