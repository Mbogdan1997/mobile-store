package com.example.demo.repository;

import com.example.demo.entity.ShoppingBascket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingBascketRepository extends JpaRepository<ShoppingBascket,Integer> {

    ShoppingBascket findById(int id);

}
