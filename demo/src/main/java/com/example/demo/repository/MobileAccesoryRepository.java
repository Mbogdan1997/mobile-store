package com.example.demo.repository;

import com.example.demo.entity.MobileAccesory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileAccesoryRepository extends JpaRepository<MobileAccesory,Integer> {

    MobileAccesory findById(int id);
}
