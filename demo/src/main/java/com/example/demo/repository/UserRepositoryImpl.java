package com.example.demo.repository;

import com.example.demo.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class UserRepositoryImpl implements UserRepository {

    @Autowired
    SessionFactory currentSession;
    private static final String selectUserByUsername="from user where username=:username";

    @Override
    public User findByUsername(String username) {
        return (User) currentSession.getCurrentSession().createQuery(selectUserByUsername).setParameter("username",username);
    }
}
