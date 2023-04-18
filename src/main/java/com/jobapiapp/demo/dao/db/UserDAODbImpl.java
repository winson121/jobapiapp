package com.jobapiapp.demo.dao.db;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobapiapp.demo.entity.User;

@Repository
public class UserDAODbImpl implements UserDAODb{

    @Autowired
    private EntityManager entityManager;

    @Override
    public User save(User user) {
        // get current session
        Session currentSession = entityManager.unwrap(Session.class);

        // save or update the user data
        currentSession.saveOrUpdate(user);

        return user;
    }

    @Override
    public User findByUsername(String username) {
        // get current hibernate session
        Session currentSession =  entityManager.unwrap(Session.class);

        // create query to get the user
        Query<User> query = currentSession.createQuery("from User where userName=:username");
        query.setParameter("username", username);

        // check if username exist in db
        User user = query.getSingleResult();

        return user;
    }
}
