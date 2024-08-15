package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class orderdto {
   
	private Long id;
    private int customerId;
    private String name;
    private String items;
    private String total;
    private String status;
}
