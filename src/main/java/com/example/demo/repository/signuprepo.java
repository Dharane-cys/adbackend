package com.example.demo.repository; 
import com.example.demo.entity.*; 
import org.springframework.data.jpa.repository.JpaRepository; 

public interface signuprepo extends JpaRepository<signupentity, Long> {
}
