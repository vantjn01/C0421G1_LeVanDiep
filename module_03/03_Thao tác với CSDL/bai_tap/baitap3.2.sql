use quanlybanhang;
insert into customer(customer_id, customer_name,customer_age)
values(1,'minh quan',10),
(2,'ngoc oanh',20),
(3,'hong ha',50);
insert into `order`(order_id,customer_id,order_date,total_price)
values(1,1,'2006/3/21',null),
(2,2,'2006/3/23',null),
(3,1,'2006/3/16',null);
insert into product(product_id, product_name,product_price)
values(1,'may giac',3),
(2,'tu lanh',5),
(3,'dieu hoa',7),
(4,'quat',1),
(5,'bep dien',2);
insert into order_detail(order_id,product_id,order_qty)
values (1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);
-- Hiển thị các thông tin  gồm oID, oDate, oPrice
-- của tất cả các hóa đơn trong bảng Order....
select order_id,order_date,total_price
from `order`;
-- Hiển thị danh sách các khách hàng đã mua hàng,
-- và danh sách sản phẩm được mua bởi các khách....
select customer_name, product_name
from customer c
join `order` o on c.customer_id = o.customer_id
join order_detail od on od.order_id = o.order_id
join product p on p.product_id = od.product_id;
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select c.customer_id, c.customer_name 
from customer c
left join `order` o on c.customer_id = o.customer_id
where o.customer_id is null;
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
-- Giá bán của từng loại được tính = odQTY*pPrice)
select o.order_id, o.order_date, od.order_qty*p.product_price as giá_bán_HĐ
from order_detail od
inner join `order` o on od.order_id = o.order_id
inner join product p on p.product_id = od.product_id;
