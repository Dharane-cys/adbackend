package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class reservedto {

	  
		private Long id; // Field for the unique identifier of the entity ite

	    private String name; // Field for the dish name of the entity item
	    
	    private String email; // Field for the dish name of the entity item
	    
	    private String date; // Field for the dish name of the entity item
	    
	    private String time; // Field for the dish name of the entity item
	    
	    private int noofpeople; //Field for the dish price of the entity item

	    private int tableno; 
	    
	    private String message;// Field for the category of the entity item

	}

