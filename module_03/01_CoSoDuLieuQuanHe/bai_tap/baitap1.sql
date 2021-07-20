create database teacherManagement;
create table `teacherManagement`.`teacher`(
`id` int not null,
`name` varchar(45) null,
`age` int not null,
`country` varchar(45) null,
primary key(`id`)
);
create database classManagement;
create table `classManagement`.`class`(
`id` int not null,
`name` varchar(45) null,
primary key(`id`)
);
