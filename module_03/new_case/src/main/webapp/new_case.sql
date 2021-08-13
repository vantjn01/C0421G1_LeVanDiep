create database if not exists new_case;
use new_case;

create table position (
position_id int primary key auto_increment,
position_name varchar(45)
);
-- Lễ tân, phục vụ, chuyên viên, giám sát, quản lý, giám đốc.
insert into position
values (1,"Lễ Tân"),(2,"Phục Vụ"),(3,"Chuyên Viên"),(4,"Giám Sát"),(5,"Quản Lý"),(6,"Giám Đốc");

create table education_degree (
education_degree_id int primary key auto_increment,
education_degree_name varchar(45)
);
insert into education_degree
values (1,"Trung Cấp"),(2,"Cao Đẳng"),(3,"Đại Học"),(4,"Sau Đại Học");

create table division (
division_id int primary key auto_increment,
division_name varchar(45)
);
insert into division
values (1,"Sale – Marketing"),(2,"Hành Chính"),(3,"Phục Vụ"),(4,"Quản Lý");


create table `role`(
role_id int primary key auto_increment,
role_name varchar(255)
);


create table `user`(
username varchar(255) primary key,
`password` varchar(255) not null
);

create table user_role(
role_id int,
username varchar(255),
foreign key (role_id) references `role`(role_id) on delete cascade on update cascade,
foreign key (username) references `user`(username) on delete cascade on update cascade,
primary key (role_id,username)
);

create table employee(
employee_id int primary key auto_increment,
employee_name varchar(45),
employee_birthday datetime,
employee_id_card varchar(45),
employee_id_salary int,
employee_id_phone int,
employee_id_email varchar(45),
employee_id_address varchar(45),
position_id int,
education_degree_id int,
division_id int,
username varchar(255),
foreign key (position_id) references `position`(position_id) on delete cascade on update cascade,
foreign key (education_degree_id) references education_degree(education_degree_id) on delete cascade on update cascade,
foreign key (division_id) references division(division_id) on delete cascade on update cascade
-- foreign key (username) references `user`(username) on delete cascade on update cascade
);
insert into employee  (employee_id,employee_name,employee_birthday,employee_id_card,employee_id_salary,
employee_id_phone,employee_id_email,employee_id_address ,position_id ,education_degree_id ,
division_id ,username)
values(1,'Diệp','1991/04/15','197266843',12000,0983236552,'diep@gmail.com','Quảng Trị',6,4,4,'diep'),
(2,'Tài','1999/04/04','112344569',11000,0983753688,'tai@gmail.com','Huế',5,4,3,'tai'),
(3,'Hà','1994/02/23','987654321',10000,0909854357,'ha@gmail.com','Đà Nẵng',4,3,4,'ha'),
(4,'Nhật','1980/10/25','111111111',9000,0908646789,'nhat@gmail.com','Quảng Nam',1,2,3,'nhat'),
(5,'Quân','1991/09/09','197297536',8000,0909876543,'quan@gmail.com','Quảng Ngãi',3,2,1,'quan');


create table customer_type(
customer_type_id int  primary key auto_increment,
customer_type_name varchar(45) 
);
insert into customer_type
values (1,"Diamond"),(2,"Platinium"),(3,"Gold"),(4,"Silver"),(5,"Member");
create table customer(
customer_id int primary key auto_increment,
customer_code varchar(45),
customer_type_id int  ,
foreign key (customer_type_id) references customer_type(customer_type_id) on delete cascade on update cascade,
customer_name varchar(45),
customer_birthday datetime,
customer_gender bit (1),
customer_id_card varchar(45),
customer_phone int,
customer_email varchar(255),
customer_address varchar(255)
);
insert into customer (customer_id,customer_code,customer_type_id,customer_name,customer_birthday,customer_gender,
customer_id_card,customer_phone,customer_email,customer_address)
values(1,'KH-1111',1,"John Biden",'1990/11/28',1,'123456789',8239483,'biden@gmail.com','America'),
(2,'KH-2222',3,"Ronaldo",'1991/11/28',1,'123456789',8239483,'cr7@gmail.com','Portugal'),
(3,'KH-3333',2,"Messi",'1992/11/28',1,'123456789',8239483,'messi@gmail.com','Argentina'),
(4,'KH-4444',4,"Kang seulgi",'1990/11/28',0,'123456789',8239483,'kang@gmail.com','Korea'),
(5,'KH-5555',4,"Thị Nở",'1991/11/28',0,'123456789',8239483,'thino@gmail.com','Đà Nẵng');
create table rent_type(
rent_type_id int  primary key auto_increment,
rent_type_name varchar(45) ,
rent_type_cost double
);
insert into rent_type
values (1,"Year",40000),(2,"Month",4000),(3,"Day",200),(4,"Hour",10);
create table service_type(
service_type_id int primary key auto_increment,
service_type_name varchar(45) 
);
insert into service_type
values (1,"Villa"),(2,"House"),(3,"Room");
create table service(
service_id int  primary key auto_increment,
service_code varchar(45),
service_name varchar(45),
service_area int,
service_cost double,
service_max_people int,
rent_type_id int ,
foreign key (rent_type_id) references rent_type(rent_type_id) on delete cascade on update cascade,
service_type_id int ,
foreign key (service_type_id) references service_type(service_type_id) on delete cascade on update cascade,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int
);
insert into service(service_id,service_code,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors)
values(1,'DV-1111','karaoke',100,1000,10,3,3,'vip','Drink Free',100,5),
(2,'DV-2222','ăn uống',200,1000,15,3,2,'vip','Drink Free',100,9),
(3,'DV-3333','bể bơi',100,1000,20,2,2,'normal','Drink Free',100,7),
(4,'DV-4444','thuê xe',20,400,10,4,3,'vip','Drink Free',100,4),
(5,'DV-5555','dịch vụ khác',300,500,30,1,1,'vip','Drink Free',100,9);
create table contract(
contract_id int primary key auto_increment,
contract_start_date datetime,
contract_end_date datetime,
contract_deposit double ,
contract_total_money double ,
employee_id int ,
foreign key (employee_id) references employee(employee_id) on delete cascade on update cascade,
customer_id int ,
service_id int ,
foreign key (customer_id) references customer(customer_id) on delete cascade on update cascade,
foreign key (service_id) references service(service_id) on delete cascade on update cascade
);
insert into contract (contract_id,contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id)
values (1,'2020/1/1','2020/1/10',1000,10000,2,2,3),
(2,'2020/11/19','2020/12/10',2000,20000,1,3,4),
(3,'2020/2/2','2020/3/3',3000,30000,5,1,2),
(4,'2021/3/3','2021/4/4',4000,40000,3,4,2),
(5,'2020/6/6','2020/8/8',5000,50000,2,2,1); 
create table attach_service(
attach_service_id int primary key auto_increment,
attach_service_name varchar(45) ,
attach_service_cost double ,
attach_service_unit int ,
attach_service_status varchar(45)
);
insert into attach_service
values (1,"massage",5000,1,"có"),
(2,"karaoke",4000,0,"không"),
(3,"ăn uống",2000,1,"có"),
(4,"thuê xe",1000,1,"có"),
(5,"dịch vụ khác",5000,1,"có");
create table contract_detail(
contract_detail_id int primary key auto_increment,
contract_id int ,
foreign key (contract_id) references contract(contract_id) on delete cascade on update cascade,
attach_service_id int,
foreign key (attach_service_id) references attach_service(attach_service_id) on delete cascade on update cascade,
quantity int 
);
insert into contract_detail (contract_detail_id,contract_id,attach_service_id,quantity)
values (1,5,1,5),
(2,4,2,4),
(3,3,3,3),
(4,2,4,2),
(5,1,5,1);
drop database new_case
