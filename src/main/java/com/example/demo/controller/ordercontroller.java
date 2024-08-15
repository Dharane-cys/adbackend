package com.example.demo.controller;

import lombok.AllArgsConstructor;
import com.example.demo.dto.*;
import com.example.demo.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/order")
public class ordercontroller {

    private orderservice orderService;

    // Build Add order REST API
    @PostMapping
    public ResponseEntity<orderdto> createOrder(@RequestBody orderdto orderDto){
        orderdto savedOrder = orderService.createOrder(orderDto);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

   // Build Get order REST API
    @GetMapping("{id}")
    public ResponseEntity<orderdto> getOrderById(@PathVariable("id") Long orderId){
        orderdto orderDto = orderService.getOrderById(orderId);
        return ResponseEntity.ok(orderDto);
    }

    // Build Get All orders REST API
    @GetMapping
    public ResponseEntity<List<orderdto>> getAllOrders(){
        List<orderdto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
    
    // Build Update orders REST API
    @PutMapping("{id}")
    public ResponseEntity<orderdto> updateOrder(@PathVariable("id") Long orderId,@RequestBody orderdto updatedOrder){
          orderdto orderDto = orderService.updateOrder(orderId, updatedOrder);
          return ResponseEntity.ok(orderDto);
    }
    
    // Build Delete order REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }

}
