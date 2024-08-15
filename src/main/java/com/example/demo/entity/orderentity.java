package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class  orderentity{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private int customerId;
    
    @Column(name = "name")
    private String name;

    @Column(name = "items")
    private String items;
    
    @Column(name="total")
    private String total;
   
    @Column(name = "order_status")
    private String status;
    
}
