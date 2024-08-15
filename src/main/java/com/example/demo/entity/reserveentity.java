package com.example.demo.entity; 

import jakarta.persistence.*; 
import lombok.AllArgsConstructor; 
import lombok.Getter; 
import lombok.NoArgsConstructor; 
import lombok.Setter; 

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity 
@Table(name = "reserve") 
public class reserveentity {


	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key value
    private Long id;
	
    @Column(name = "username")
    private String name;
    
    @Column(name = "email_id")
    private String email;
    
    @Column(name = "date") 
    private String date;
    
    @Column(name = "time") 
    private String time;

    @Column(name = "no_of_people") 
    private int noofpeople;
    
    @Column(name = "table_no") 
    private int tableno;
    
    @Column(name = "message")
    private String message;
  
}
