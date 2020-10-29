package com.example.demo.repository;

import com.example.demo.dto.ItemDTO;
import com.example.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Integer> {


    List<Item> findByName(String name);

    List<Item> findByIsActive( boolean active);

    Item findById(int id);
}
