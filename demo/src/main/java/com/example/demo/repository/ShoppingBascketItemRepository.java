package com.example.demo.repository;

import com.example.demo.entity.ShoppingBascketItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingBascketItemRepository extends JpaRepository<ShoppingBascketItem,Integer> {


    ShoppingBascketItem findById(int id);
    void deleteAllByItem_Id(int id);
}
