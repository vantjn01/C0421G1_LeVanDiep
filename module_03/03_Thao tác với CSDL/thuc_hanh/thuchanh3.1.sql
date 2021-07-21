create database thuchanh3_1;
use thuchanh3_1;
create table Class(
class_id int ,
class_name varchar(30),
start_date datetime,
`status` bit
);
insert into class(class_id, class_name, start_date,`status`)
values(1,'a1','2008/12/20',1),
(2,'a2','2008/12/22',1),
(3,'b3',current_date(),0);
create table Student(
Student_id int ,
Student_name varchar(30),
adress varchar(30),
phone int,
`status` bit,
class_id int
);
insert into Student(Student_id, student_name, adress,phone,`status`,class_id)
values(1,'hung','hanoi',0987655861,1,1);
insert into Student(student_id, student_name, adress,`status`,class_id)
values(2,'hoa','haiphong',1,1);
insert into Student(student_id, student_name, adress,phone,`status`,class_id)
values(3,'manh','hcm',0987989000,1,1);
create table `subject`(
sub_id int ,
sub_name varchar(30),
credit int,
`status` bit
);
insert into `subject`(sub_id, sub_name, credit,`status`)
values(1,'cf',5,1),
(2,'c',6,1),
(3,'hdj',5,1),
(4,'rdbms',10,1);
create table mark(
mark_id int,
sub_id int ,
student_id int,
mark int,
examtimes int
);
insert into mark(mark_id,sub_id,student_id , mark ,examtimes )
values(1,1,1,8,1),
(2,1,2,10,2),
(3,2,1,12,1)
-- drop database thuchanh3_1;