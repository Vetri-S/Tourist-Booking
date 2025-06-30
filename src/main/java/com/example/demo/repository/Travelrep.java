package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Modal.Travel;


public interface Travelrep extends JpaRepository<Travel, Long>{
    
}