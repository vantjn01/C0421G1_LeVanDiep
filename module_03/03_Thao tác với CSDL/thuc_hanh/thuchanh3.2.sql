use thuchanh3_1;
-- Hiển thị danh sách tất cả các học viên
select  Student_name from student;
-- Hiển thị danh sách các học viên đang theo học.
select * from student;
-- cách 2
SELECT *
FROM Student
WHERE Status = true;
-- Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ.
select * from subject where credit<10;
-- Hiển thị danh sách học viên lớp A1
-- Join 2 bảng Student và Class 
-- Sử dụng câu lệnh Where C.ClassName ='A1' để hiển thị danh sách học viên lớp A1
SELECT S.Student_Id, S.Student_Name, C.Class_Name
FROM Student S join Class C on S.Class_Id = C.Class_ID
WHERE C.Class_Name = 'A1';
-- Hiển thị điểm môn CF của các học viên.
-- join 3 bảng Student, subject và mark lại với nhau sau đó hiển
-- thị số điểm
SELECT S.Student_Id, S.Student_Name, Sub.Sub_Name, M.Mark
FROM Student S join Mark M on S.Student_Id = M.Student_Id join
 `Subject` Sub on M.Sub_Id = Sub.Sub_Id
 WHERE Sub.Sub_Name = 'CF';
-- hiển thị điểm môn CF của các học viên
