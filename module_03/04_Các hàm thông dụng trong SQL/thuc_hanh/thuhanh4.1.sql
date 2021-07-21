use thuchanh3_1;
-- Hiển thị số lượng sinh viên ở từng nơi
SELECT Adress, COUNT(Student_Id) AS 'Số lượng học viên'
FROM Student
GROUP BY Adress;
-- Tính điểm trung bình các môn học của mỗi học viên
SELECT S.Student_Id,S.Student_Name, AVG(Mark)
FROM Student S join Mark M on S.Student_Id = M.Student_Id
GROUP BY S.Student_Id, S.Student_Name;
-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
SELECT S.Student_Id,S.Student_Name, AVG(Mark)
FROM Student S join Mark M on S.Student_Id = M.Student_Id
GROUP BY S.Student_Id, S.Student_Name
HAVING AVG(Mark) > 15;
-- Hiển thị danh sách điểm trung bình của các học viên
SELECT S.Student_Id, S.Student_Name, AVG(Mark)
FROM Student S join Mark M on S.Student_Id = M.Student_Id
GROUP BY S.Student_Id, S.Student_Name
-- Sử dụng Having và All để tìm học viên có điểm trung bình lớn nhất
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.Student_Id);