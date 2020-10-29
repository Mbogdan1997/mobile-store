package com.example.demo.repository;

import com.example.demo.entity.Item;
import com.example.demo.mapper.ItemMapperAbstr;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemRepositoryImpl implements ItemRepository {

   /* @Autowired
    SessionFactory currentSession;
    private String findItemsByNameQuery="from item where name=:=name";

    public List<Item> findItemsByName(String name){
        Query query=currentSession.getCurrentSession().createQuery(findItemsByNameQuery).setParameter("name",name);
        List<Item> items=new ArrayList<>();
        for(Object object:query.list()){
            items.add((Item) object);
        }
        return items;
    }*/
}
