drop database if exists thuchanh3_1;
create database thuchanh3_1;
use thuchanh3_1;
-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select * from student where Student_name like 'h%';
-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select * from class where month(start_date)=12;
-- Hiển thị tất cả các thông tin môn học
-- có credit trong khoảng từ 3-5.
select * from subject where credit >= 3 and credit <=5;
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
SET SQL_SAFE_UPDATES = 0;
update student set class_ID = 2  where student_Name = 'Hung';
-- Hiển thị các thông tin: StudentName, SubName, Mark.
-- Dữ liệu sắp xếp theo điểm thi (mark) giảm dần.
-- nếu trùng sắp theo tên tăng dần.
select s.Student_Name, sub.Sub_Name, m.Mark
from student s inner join Mark m on s.Student_Id = m.Student_Id inner join `subject` sub on sub.Sub_Id = m.Sub_Id
order by mark desc,s.student_name asc;
