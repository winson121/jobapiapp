package com.jobapiapp.demo.dao.db;


import com.jobapiapp.demo.entity.User;

public interface UserDAODb {

    User save(User user);

    User findByUsername(String username);
}
