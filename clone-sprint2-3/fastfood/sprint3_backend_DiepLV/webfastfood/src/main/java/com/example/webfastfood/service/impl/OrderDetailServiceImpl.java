package com.example.webfastfood.service.impl;

import com.example.webfastfood.entity.oders.OrderDetail;
import com.example.webfastfood.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {
//    @Autowired
//    private IOrderDetailRepository iOrderDetailRepository;
//
//    @Override
//    public List<OrderDetail> list() {
//        return this.iOrderDetailRepository.findAll();
//    }
//
//    @Override
//    public void saveOrder(OrderDetail orderDetail) {
//        this.iOrderDetailRepository.createOrderDetail(orderDetail.getFood().getFoodId(), orderDetail.getOrders().getOrdersId(), orderDetail.getQuantityFood());
//    }
//
//    @Override
//    public List<OrderDetail> findCartCustomer() {
//        return this.iOrderDetailRepository.getFindByCustomer();
//    }
}
