create database QuanLySinhVien;
use QuanLySinhVien;
create table Class(
ClassId int not null primary key auto_increment,
ClassName varchar(60) not null,
StartDate datetime not null,
`Status` bit
);
create table Student(
StudentId int not null primary key auto_increment,
StudentName varchar(30) not null,
Adrress varchar(50),
Phone varchar(20),
`Status` bit,
ClassId int not null,
foreign key (ClassId) references Class(ClassId)
);
create table `Subject`(
SubId int not null primary key auto_increment,
SubName varchar(30) not null,
Credit tinyint not null default 1 check(Credit>=1),
`Status` bit default 1
);
create table Mark(
MarkId int not null primary key auto_increment,
SubId int not null,
StudentId int not null,
unique(SubId, StudentId),
foreign key (SubId) references `Subject`(SubId),
foreign key (StudentId) references Student(StudentId),
Mark float default 0 check(mark between 0 and 100),
ExamTimes tinyint default 1
)
