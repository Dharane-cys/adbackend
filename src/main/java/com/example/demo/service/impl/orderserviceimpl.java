package com.example.demo.service.impl;

import lombok.AllArgsConstructor;
import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import com.example.demo.mapper.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class orderserviceimpl implements orderservice {

    private orderrepo orderRepository;

    @Override
    public orderdto createOrder(orderdto orderDto) {

        orderentity order = ordermapper.mapToOrder(orderDto);
        orderentity savedOrder = orderRepository.save(order);
        return ordermapper.mapToOrderDto(savedOrder);
    }
    
    @Override
    public orderdto getOrderById(Long orderId) {
        orderentity order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                new ResourceNotFoundException("Order not exists with given id : " + orderId));

        return ordermapper.mapToOrderDto(order);
    }

    @Override
    public List<orderdto> getAllOrders() {
        List<orderentity> orders = orderRepository.findAll();
        return orders.stream().map((order) -> ordermapper.mapToOrderDto(order))
                .collect(Collectors.toList());
    }
    
    @Override
    public orderdto updateOrder(Long orderId, orderdto updatedOrder) {

        orderentity order = orderRepository.findById(orderId).orElseThrow(
                () -> new ResourceNotFoundException("Order not exists with given id: " + orderId)
        );

        order.setCustomerId(updatedOrder.getCustomerId());
        order.setName(updatedOrder.getName());
        order.setItems(updatedOrder.getItems());
        order.setTotal(updatedOrder.getTotal());
        order.setStatus(updatedOrder.getStatus());
        orderentity updatedOrderObj = orderRepository.save(order);

        return ordermapper.mapToOrderDto(updatedOrderObj);
    }
    
    @Override
    public void deleteOrder(Long orderId) {

        orderentity order = orderRepository.findById(orderId).orElseThrow(
                () -> new ResourceNotFoundException("Order is not exists with given id: " + orderId)
        );

        orderRepository.delete(order);
    }
   
}
