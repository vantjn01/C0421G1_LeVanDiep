package com.example.webfastfood.repository;

import com.example.webfastfood.entity.oders.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//@Transactional
//@Repository
//public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer>{
////    @Modifying
////    @Query(value = "INSERT INTO `food`.`order_detail` (`food_id`, `orders_id`, `quantity_food`, `customer_id`) VALUES (?1, ?2,?3, '1')", nativeQuery = true)
////    void createOrderDetail(int foodId, int ordersId, int quantityFood);
////
////    @Query(value = "select * \n" +
////            "from order_detail\n" +
////            "where customer_id = 1", nativeQuery = true)
////    List<OrderDetail> getFindByCustomer();
//
//}
