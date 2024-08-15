package com.example.demo.service;

import com.example.demo.dto.*;

import java.util.List;

public interface orderservice {
    orderdto createOrder(orderdto orderDto);
    
    orderdto getOrderById(Long orderId);

    List<orderdto> getAllOrders();
    
    orderdto updateOrder(Long orderId, orderdto updatedOrder);
    
    void deleteOrder(Long orderId);

}
