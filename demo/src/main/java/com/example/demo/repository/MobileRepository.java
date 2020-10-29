package com.example.demo.repository;

import com.example.demo.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepository extends JpaRepository<Mobile,Integer> {

    Mobile findById(int id);
}
