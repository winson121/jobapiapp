package com.jobapiapp.demo.service;

import com.jobapiapp.demo.dao.db.UserDAODb;
import com.jobapiapp.demo.dto.UserDTO;
import com.jobapiapp.demo.entity.User;
import com.jobapiapp.demo.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import javax.transaction.Transactional;

@Service
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService{

    @Autowired
    private UserDAODb userDAODb;

    @Autowired
    private Mapper mapper;

    @Autowired
    @Qualifier("customPasswordEncoder")
    private PasswordEncoder bcryptEncoder;

    @Override
    @Transactional
    public User save(UserDTO userDto) {
        userDto.setPassword(bcryptEncoder.encode(userDto.getPassword()));
        return userDAODb.save(mapper.toEntity(userDto));
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userDAODb.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid Username or Password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }
}
