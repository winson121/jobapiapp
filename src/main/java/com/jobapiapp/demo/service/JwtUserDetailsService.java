package com.jobapiapp.demo.service;

import com.jobapiapp.demo.dto.UserDTO;
import com.jobapiapp.demo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface JwtUserDetailsService extends UserDetailsService {

    User save(UserDTO userDTO);

    User findByUsername(String username);

}
