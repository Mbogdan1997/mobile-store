package com.example.demo.repository;

import com.example.demo.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress,Integer> {

    Adress findById(int id);
}
