package com.example.demo.repository; 
import com.example.demo.entity.*; 
import org.springframework.data.jpa.repository.JpaRepository; 

public interface orderrepo extends JpaRepository<orderentity, Long> {
}
