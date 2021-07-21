use thuchanh3_1;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * 
from `subject` where credit = (select max(credit) from `subject`);
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select *
from `subject` s
join mark on mark.sub_id = s.sub_id  -- join điểm thi (mark) với môn học (subject)
where mark = (select max(mark) from mark);
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên
select *
from student s -- join student và mark 
join mark m on m.student_Id = s.student_Id
group by s.student_Id
order by mark desc; --  xếp hạng theo thứ tự điểm giảm dần